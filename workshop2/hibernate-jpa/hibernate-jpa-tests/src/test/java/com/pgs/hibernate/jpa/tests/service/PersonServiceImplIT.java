package com.pgs.hibernate.jpa.tests.service;

import com.pgs.hibernate.jpa.tests.config.AppConfig;
import com.pgs.hibernate.jpa.tests.model.Person;
import com.pgs.hibernate.jpa.tests.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author wszybisty
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@EnableTransactionManagement
public class PersonServiceImplIT {

    @SpyBean
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test
    public void persistingData() {
        final Person newPerson = newPerson();

        System.out.println("Person before persist:" + newPerson);

        Person person = personService.save(newPerson);

        assertThat(person.getPersonId(), is(notNullValue()));
        assertThat(person.getName(), is(equalTo(newPerson.getName())));

        System.out.println("Person after persist:" + person);
    }

    @Test
    public void save_detachedEntity_shouldFailWithException() {
        final Person newPerson = newPerson();

        Person persistedPerson = personService.save(newPerson);

        final Person detached = newPerson();
        detached.setPersonId(persistedPerson.getPersonId());
        detached.setName("Name");

        try {
            personService.save(detached);
            fail("Exception expected");
        } catch (Exception e) {
            assertThat(e, is(instanceOf(PersistenceException.class)));
            assertThat(e.getMessage(), is(CoreMatchers.containsString("detached entity passed to persist")));
        }
    }

    @Test
    public void merge_detachedEntity_shouldCommit() {
        final Person newPerson = newPerson();

        Person persistedPerson = personService.save(newPerson);

        final Person detached = newPerson();
        detached.setPersonId(persistedPerson.getPersonId());
        detached.setName("Name");

        personService.merge(detached);
    }

    @Test
    public void saveAndFind_objectAlreadyInSession_shouldNotAccessDatabaseTwice() {
        final Person newPerson = newPerson();

        personService.saveAndFind(newPerson);

        fail("Check console logs");
    }

    @Test
    public void merge_severalConcurrentUpdates_schouldThrowException() throws InterruptedException {
        final Person newPerson = newPerson();
        Long personId = personService.save(newPerson).getPersonId();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final Thread thread = new Thread(() -> {
                Person person = person(personId);
                personService.merge(person);
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        fail("Check console logs for: 'Row was updated or deleted by another transaction'");
    }

    @Test
    public void update_updateSameRecordTwice_schouldThrowException() throws InterruptedException {
        final Person newPerson = newPerson();
        Long personId = personService.save(newPerson).getPersonId();

        Person person1 = personService.findOne(personId);
        Person person2 = personService.findOne(personId);

        person1.setName("Name1");
        person2.setName("Name2");

        personService.merge(person1);

        try {
            personService.merge(person2);
            fail("Exception expected");
        } catch (PersistenceException ex) {
            
        }
    }
    
    @Test
    public void findOneWithLock() throws InterruptedException {
        final Person newPerson = newPerson();
        Long personId = personService.save(newPerson).getPersonId();

        final Thread thread1 = new Thread(() -> {personService.findAndUpdateWithLock(personId, "LockedPersonName1");});
        final Thread thread2 = new Thread(() -> {personService.findAndUpdateWithLock(personId, "LockedPersonName2");});
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
    }

    private Person newPerson() {
        Person person = new Person();
        person.setName("New Person");
        return person;
    }

    private Person person(Long personId) {
        Person person = new Person();
        person.setPersonId(personId);
        person.setName("Person");
        return person;
    }

}
