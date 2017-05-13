package com.pgs.service.tester.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wszybisty
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setupTest() {
        System.out.println("    before test");
        calculator = new Calculator();
    }

    @After
    public void teardownTest() {
        System.out.println("    after test");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @Test
    public void fractionalTest0() {
        System.out.println("        fractionalTest0");
        long result = calculator.fractional(1);

        assertThat(result, equalTo(1L));
    }

    @Test
    public void fractionalTest1() {
        System.out.println("        fractionalTest1");
        long result = calculator.fractional(0);

        assertThat(result, equalTo(1L));
    }

    @Test
    public void fractionalTest5() {
        System.out.println("        fractionalTest5");
        long result = calculator.fractional(5);

        assertThat(result, equalTo(120L));
    }
}
