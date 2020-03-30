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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author g905
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ru.g905.fool.CardTest.class, ru.g905.fool.IGameLogicTest.class, ru.g905.fool.SuitsTest.class, ru.g905.fool.GameLogicTest.class, ru.g905.fool.PlayerTest.class, ru.g905.fool.GameTest.class, ru.g905.fool.StackTest.class, ru.g905.fool.MainTest.class, ru.g905.fool.WeightsTest.class})
public class FoolSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
