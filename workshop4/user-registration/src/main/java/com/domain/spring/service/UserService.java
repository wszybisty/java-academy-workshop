package com.domain.spring.service;

import com.domain.spring.exception.UserRegistrationException;
import com.domain.spring.model.User;
import com.domain.spring.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wszybisty
 */
@Service
public class UserService {
    
    private final NotificationService notificationService;
    private final UserRepository userRepository;

    @Autowired
    public UserService(NotificationService notificationService, UserRepository userRepository) {
        this.notificationService = notificationService;
        this.userRepository = userRepository;
    }
    
    public User registerUser(User user) throws UserRegistrationException {
        
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserRegistrationException(UserRegistrationException.FailReason.USER_ALREADY_EXISTS);
        }
        
        user = userRepository.save(user);
        
        notificationService.sendWelcomeMessage(user);
        
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    
}
