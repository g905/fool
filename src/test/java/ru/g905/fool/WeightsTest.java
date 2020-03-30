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
public class WeightsTest {

    public WeightsTest() {
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
     * Test of values method, of class Weights.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Weights[] expResult = null;
        Weights[] result = Weights.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Weights.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "";
        Weights expResult = null;
        Weights result = Weights.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Weights.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Weights instance = null;
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rusName method, of class Weights.
     */
    @Test
    public void testRusName() {
        System.out.println("rusName");
        Weights instance = null;
        String expResult = "";
        String result = instance.rusName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
