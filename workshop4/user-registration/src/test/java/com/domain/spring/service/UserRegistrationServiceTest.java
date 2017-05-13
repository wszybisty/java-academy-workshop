package com.domain.spring.service;

import com.domain.spring.exception.UserRegistrationException;
import com.domain.spring.model.User;
import com.domain.spring.repository.UserRepository;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author wszybisty
 */
public class UserRegistrationServiceTest {

    private NotificationService notificationService;

    private UserRepository userRepository;

    private UserService userRegistrationService;


    private User makeUser() {
        return new User(null, "janek.kowalski", "Jan", "Kowalski", "janek.kowalski@onet.pl", null);
    }

}
