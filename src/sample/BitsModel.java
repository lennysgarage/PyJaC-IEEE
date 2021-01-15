package sample;

public class BitsModel extends Observable {

    public void updateBits() {
        notifyObservers();
    }
}
