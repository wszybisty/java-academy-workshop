package com.domain.spring.exception;

/**
 *
 * @author wszybisty
 */
public class UserRegistrationException extends Exception {

    private final FailReason failReason;

    public enum FailReason {
        USER_ALREADY_EXISTS
    }
    
    public UserRegistrationException(FailReason failReason) {
        this.failReason = failReason;
    }

    public FailReason getFailReason() {
        return failReason;
    }
    
}
