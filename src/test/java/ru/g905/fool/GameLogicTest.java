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
public class GameLogicTest {

    public GameLogicTest() {
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
     * Test of init method, of class GameLogic.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        GameLogic instance = new GameLogic();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class GameLogic.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        GameLogic instance = new GameLogic();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of takeOff method, of class GameLogic.
     */
    @Test
    public void testTakeOff() throws Exception {
        System.out.println("takeOff");
        GameLogic instance = new GameLogic();
        instance.takeOff();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of whoIsFirst method, of class GameLogic.
     */
    @Test
    public void testWhoIsFirst() {
        System.out.println("whoIsFirst");
        GameLogic instance = new GameLogic();
        instance.whoIsFirst();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loop method, of class GameLogic.
     */
    @Test
    public void testLoop() {
        System.out.println("loop");
        GameLogic instance = new GameLogic();
        instance.loop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
