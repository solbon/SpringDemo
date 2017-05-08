package com.example;

import org.springframework.context.ApplicationEvent;

/**
 * Created by solina on 02.05.2017.
 */
public class DrawEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DrawEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "Draw Event occurred";
    }
}
