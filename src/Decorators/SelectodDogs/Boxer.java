package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Boxer extends SelectedDog {

    public Boxer() {
        description = "Boxer";
    }

    @Override
    public double cost() {
        return 1.26;
    }
}
