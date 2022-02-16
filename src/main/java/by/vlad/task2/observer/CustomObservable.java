package by.vlad.task2.observer;

public interface CustomObservable {
    void attach(CustomArrayObserver customArrayObserver);
    void detach(CustomArrayObserver customArrayObserver);
    void notifyObservers();
}
