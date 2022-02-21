package by.vlad.task1.observer;

public interface CustomObservable {
    void attach(CustomArrayObserver customArrayObserver);
    void detach(CustomArrayObserver customArrayObserver);
    void notifyObservers();
}
