package com.rollingstone.events;

import com.rollingstone.spring.model.Pricing;
import org.springframework.context.ApplicationEvent;

public class PricingEvent
		extends ApplicationEvent {

    private String  eventType;
    private Pricing pricing;

    public String getEventType() {
	return eventType;
    }

    public void setEventType(String eventType) {
	this.eventType = eventType;
    }

    public Pricing getPricing() {
	return pricing;
    }

    public void setPricing(Pricing pricing) {
	this.pricing = pricing;
    }

    public PricingEvent(Object source, String eventType, Pricing pricing) {
	super(source);
	this.eventType = eventType;
	this.pricing = pricing;
    }

    @Override
    public String toString() {
	return "Pricing Event [eventType=" + eventType + ", pricing=" + pricing + "]";
    }

}
