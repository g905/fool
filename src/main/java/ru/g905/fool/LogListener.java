/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.fool;

/**
 *
 * @author zharnikov
 */
public class LogListener implements IEventListener {

    private String msg;

    public void LogListener(String msg) {
        this.msg = msg;
    }

    @Override
    public void update() {
        System.out.print(msg);
    }
}
