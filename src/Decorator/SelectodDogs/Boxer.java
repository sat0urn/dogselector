package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Boxer extends SelectedDog {

    public Boxer() {
        description = "Boxer";
    }

    @Override
    public double cost() {
        return 1.26;
    }
}
