package Observer;

import Observer.Observable;
import Observer.Observer;
import Controllers.ClientController;

import java.util.List;

public class DogAcquisition implements Observable {

    List<Observer> observers;
    ClientController clientController;

    public DogAcquisition() {
        clientController = new ClientController();
        observers = clientController.getAllClients();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        clientController.addNewClient(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        clientController.removeClient(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void notifyObserver(String observerName) {
        for (Observer observer : observers) {
            if (observer.getName().equals(observerName)) {
                observer.update();
            }
        }
    }
}
