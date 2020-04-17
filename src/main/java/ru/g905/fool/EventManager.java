/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.fool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zharnikov
 */
public class EventManager {

    private Map<String, List<IEventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String o : operations) {
            listeners.put(o, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, IEventListener listener) {
        List<IEventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, IEventListener listener) {
        List<IEventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType) {
        List<IEventListener> users = listeners.get(eventType);
        for (IEventListener user : users) {
            user.update();
        }
    }

}
