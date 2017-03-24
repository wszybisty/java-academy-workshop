package com.domain.spring;

/**
 *
 * @author wszybisty
 */
public class Application {
    
    public static void main(String[] args) {
        
        UserRegistrationService service = new UserRegistrationService();
        
        final User user = new User("wszybisty", "Wojtek", "Szybisty", "wojciech.szybisty@gmail.com", "+48888999000");
        
        service.registerUser(user);
        
    }
}
