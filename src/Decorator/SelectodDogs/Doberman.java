package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Doberman extends SelectedDog {

    public Doberman() {
        description = "Doberman";
    }

    @Override
    public double cost() {
        return 1.31;
    }
}
