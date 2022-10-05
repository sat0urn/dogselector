package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Samoed extends SelectedDog {

    public Samoed() {
        description = "Samoed";
    }

    @Override
    public double cost() {
        return 1.36;
    }
}
