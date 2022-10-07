package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Haski extends SelectedDog {

    public Haski() {
        description = "Haski";
    }

    @Override
    public double cost() {
        return 1.32;
    }
}
