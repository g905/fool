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
public class IGameLogicTest {

    public IGameLogicTest() {
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
     * Test of init method, of class IGameLogic.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        IGameLogic instance = new IGameLogicImpl();
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class IGameLogic.
     */
    @Test
    public void testStart() throws Exception {
        System.out.println("start");
        IGameLogic instance = new IGameLogicImpl();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class IGameLogicImpl implements IGameLogic {

        public void init() {
        }

        public void start() throws Exception {
        }
    }

}
