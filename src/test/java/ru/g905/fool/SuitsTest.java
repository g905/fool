/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.fool;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g905
 */
public class SuitsTest {

    public SuitsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class Suits.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Suits[] expResult = null;
        Suits[] result = Suits.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Suits.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "";
        Suits expResult = null;
        Suits result = Suits.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rusName method, of class Suits.
     */
    @Test
    public void testRusName() {
        System.out.println("rusName");
        Suits instance = null;
        String expResult = "";
        String result = instance.rusName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
