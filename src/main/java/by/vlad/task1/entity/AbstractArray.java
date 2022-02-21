package by.vlad.task1.entity;

import by.vlad.task1.observer.CustomArrayEvent;
import by.vlad.task1.observer.CustomArrayObserver;
import by.vlad.task1.observer.CustomObservable;
import by.vlad.task1.util.IdGenerator;

public abstract class AbstractArray implements CustomObservable {
    private int id;
    private CustomArrayObserver customArrayObserver;

    public AbstractArray() {
        this.id = IdGenerator.getInstance().getId();
    }

    public int getId() {
        return id;
    }

    @Override
    public void attach(CustomArrayObserver customArrayObserver) {
        this.customArrayObserver = customArrayObserver;
    }

    @Override
    public void detach(CustomArrayObserver customArrayObserver) {
        this.customArrayObserver = null;
    }

    @Override
    public void notifyObservers() {
        if (customArrayObserver != null){
            customArrayObserver.parameterChanged(new CustomArrayEvent(this));
        }
    }
}
