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
public class PlayerTest {

    public PlayerTest() {
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
     * Test of takeCards method, of class Player.
     */
    @Test
    public void testTakeCards() {
        System.out.println("takeCards");
        Stack s = null;
        int q = 0;
        Player instance = null;
        instance.takeCards(s, q);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeCard method, of class Player.
     */
    @Test
    public void testTakeCard() throws Exception {
        System.out.println("takeCard");
        Stack s = null;
        Player instance = null;
        instance.takeCard(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printName method, of class Player.
     */
    @Test
    public void testPrintName() {
        System.out.println("printName");
        Player instance = null;
        instance.printName();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuant method, of class Player.
     */
    @Test
    public void testGetQuant() {
        System.out.println("getQuant");
        Player instance = null;
        int expResult = 0;
        int result = instance.getQuant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printCards method, of class Player.
     */
    @Test
    public void testPrintCards() {
        System.out.println("printCards");
        Player instance = null;
        instance.printCards();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortCards method, of class Player.
     */
    @Test
    public void testSortCards() {
        System.out.println("sortCards");
        Suits trump = null;
        Player instance = null;
        instance.sortCards(trump);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
