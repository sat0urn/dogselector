package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Corgi extends SelectedDog {

    public Corgi() {
        description = "Corgi";
    }

    @Override
    public double cost() {
        return 1.29;
    }
}
