package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Puddle extends SelectedDog {

    public Puddle() {
        description = "Puddle";
    }

    @Override
    public double cost() {
        return 1.34;
    }
}
