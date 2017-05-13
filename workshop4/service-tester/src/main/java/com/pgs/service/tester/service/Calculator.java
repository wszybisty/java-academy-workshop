package com.pgs.service.tester.service;

/**
 *
 * @author wszybisty
 */
public class Calculator {
    
    public long fractional(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater or equal 0");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fractional(n -1);
    }
    
    public long fibonnaci(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater or equal 0");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonnaci(n-1) + fibonnaci(n-2);
    }
}
