package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Spitz extends SelectedDog {

    public Spitz() {
        description = "Spitz";
    }

    @Override
    public double cost() {
        return 1.37;
    }
}
