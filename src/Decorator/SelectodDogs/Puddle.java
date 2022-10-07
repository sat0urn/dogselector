package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Puddle extends SelectedDog {

    public Puddle() {
        description = "Puddle";
    }

    @Override
    public double cost() {
        return 1.34;
    }
}
