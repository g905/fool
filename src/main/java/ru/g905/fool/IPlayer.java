/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.fool;

import java.util.ArrayList;

/**
 *
 * @author zharnikov
 */
public interface IPlayer {

    Card attack();

    boolean checkSkip();

    ArrayList<Card> getCards();

    Card getLowestTrump(Suits trump);

    String getName();

    boolean getOut();

    int getQuant();

    boolean getSkip();

    void printCards();

    void setOut(boolean val);

    void setSkip(boolean val);

    void sortCards(Suits trump);

    ArrayList<Card> tDefence(Stack table);

    void takeCard(Stack s) throws Exception;

    void takeCards(Stack s, int q);

    void toss(Stack table, IPlayer opponent);

    public void printName();

}
