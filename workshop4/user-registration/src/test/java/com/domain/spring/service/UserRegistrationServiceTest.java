package com.domain.spring.service;

import com.domain.spring.exception.UserRegistrationException;
import com.domain.spring.model.User;
import com.domain.spring.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 *
 * @author wszybisty
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationServiceTest {

    @Mock
    private NotificationService notificationService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userRegistrationService;

    @Test
    public void registerUser_userDoesNotExist_shouldSaveUserAndSendWelcomeMessage() throws UserRegistrationException {
        User newUser = makeUser();
        User savedUser = makeUser();
        savedUser.setUserId(23L);
        when(userRepository.save(newUser)).thenReturn(savedUser);

        final User registeredUser = userRegistrationService.registerUser(newUser);

        assertThat(registeredUser, is(notNullValue()));
        assertThat(registeredUser.getUserId(), is(notNullValue()));

        verify(notificationService).sendWelcomeMessage(any());
        verifyNoMoreInteractions(notificationService);
        //verifyZeroInteractions(notificationService);
    }

    @Test
    public void registerUser_userAlreadyExists_shouldThrowException() {
        User existingUser = makeUser();
        when(userRepository.findByUsername(existingUser.getUsername()))
                .thenReturn(makeUser());

        final Throwable coughtException = catchThrowable(() -> userRegistrationService.registerUser(existingUser));

        assertThat(coughtException, instanceOf(UserRegistrationException.class));
        final UserRegistrationException userRegistrationException = (UserRegistrationException) coughtException;
        assertThat(userRegistrationException.getFailReason(),
                equalTo(UserRegistrationException.FailReason.USER_ALREADY_EXISTS));
    }

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    public void registerUser_userDoesNotExist_shouldSaveUserAndSendWelcomeMessage2() throws UserRegistrationException {
        User newUser = makeUser();
        User savedUser = makeUser();
        savedUser.setUserId(23L);
        when(userRepository.save(newUser)).thenReturn(savedUser);

        final User registeredUser = userRegistrationService.registerUser(newUser);

        assertThat(registeredUser, is(notNullValue()));
        assertThat(registeredUser.getUserId(), is(notNullValue()));

        verify(notificationService).sendWelcomeMessage(userCaptor.capture());
        assertThat(userCaptor.getValue().getUserId(), is(equalTo(23L)));
        verifyNoMoreInteractions(notificationService);
        //verifyZeroInteractions(notificationService);
    }

    private User makeUser() {
        return new User(null, "janek.kowalski", "Jan", "Kowalski", "janek.kowalski@onet.pl", null);
    }

}
