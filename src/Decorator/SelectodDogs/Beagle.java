package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Beagle extends SelectedDog {

    public Beagle() {
        description = "Beagle";
    }

    @Override
    public double cost() {
        return 1.25;
    }
}
