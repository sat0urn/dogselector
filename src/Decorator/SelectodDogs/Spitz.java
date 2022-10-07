package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Spitz extends SelectedDog {

    public Spitz() {
        description = "Spitz";
    }

    @Override
    public double cost() {
        return 1.37;
    }
}
