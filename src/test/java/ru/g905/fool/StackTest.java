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
public class StackTest {

    public StackTest() {
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
     * Test of getLength method, of class Stack.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Stack instance = new Stack();
        int expResult = 0;
        int result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffle method, of class Stack.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        Stack instance = new Stack();
        instance.shuffle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeCard method, of class Stack.
     */
    @Test
    public void testTakeCard() throws Exception {
        System.out.println("takeCard");
        Stack instance = new Stack();
        Card expResult = null;
        Card result = instance.takeCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of putCard method, of class Stack.
     */
    @Test
    public void testPutCard() {
        System.out.println("putCard");
        Card card = null;
        Stack instance = new Stack();
        instance.putCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of putCardToFirst method, of class Stack.
     */
    @Test
    public void testPutCardToFirst() {
        System.out.println("putCardToFirst");
        Card card = null;
        Stack instance = new Stack();
        instance.putCardToFirst(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printStack method, of class Stack.
     */
    @Test
    public void testPrintStack() throws Exception {
        System.out.println("printStack");
        Stack instance = new Stack();
        instance.printStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTrump method, of class Stack.
     */
    @Test
    public void testSetTrump() throws Exception {
        System.out.println("setTrump");
        Suits trump = null;
        Stack instance = new Stack();
        instance.setTrump(trump);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
