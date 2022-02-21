package by.vlad.task1.observer;

import by.vlad.task1.entity.CustomArray;

import java.util.EventObject;

public class CustomArrayEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomArrayEvent(Object source) {
        super(source);
    }

    @Override
    public CustomArray getSource() {
        return (CustomArray) super.getSource();
    }
}
