package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Chiwawa extends SelectedDog {

    public Chiwawa() {
        description = "Chiwawa";
    }

    @Override
    public double cost() {
        return 1.28;
    }
}
