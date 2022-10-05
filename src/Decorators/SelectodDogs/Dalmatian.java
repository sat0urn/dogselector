package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Dalmatian extends SelectedDog {

    public Dalmatian() {
        description = "Dalmatian";
    }

    @Override
    public double cost() {
        return 1.30;
    }
}
