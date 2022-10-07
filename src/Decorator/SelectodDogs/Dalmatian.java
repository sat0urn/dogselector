package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Dalmatian extends SelectedDog {

    public Dalmatian() {
        description = "Dalmatian";
    }

    @Override
    public double cost() {
        return 1.30;
    }
}
