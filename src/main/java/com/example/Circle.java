package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

/**
 * Created by Solbon on 2017-04-27.
 */
public class Circle implements Shape, ApplicationEventPublisherAware {

    private Point center;

    @Autowired
    private MessageSource messageSource;

    private ApplicationEventPublisher publisher;

    @Override
    public void draw() {
        System.out.println(this.messageSource.getMessage("drawing.circle", null, null));
        System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, null));
        ApplicationEvent event = new DrawEvent(this);
        publisher.publishEvent(event);
    }

    public Point getCenter() {
        return center;
    }

    @Autowired
    @Qualifier("pointB")
    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
