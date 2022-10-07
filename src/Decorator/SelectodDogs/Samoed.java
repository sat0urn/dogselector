package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Samoed extends SelectedDog {

    public Samoed() {
        description = "Samoed";
    }

    @Override
    public double cost() {
        return 1.36;
    }
}
