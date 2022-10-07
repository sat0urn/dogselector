package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Bulldog extends SelectedDog {

    public Bulldog() {
        description = "Bulldog";
    }

    @Override
    public double cost() {
        return 1.27;
    }
}
