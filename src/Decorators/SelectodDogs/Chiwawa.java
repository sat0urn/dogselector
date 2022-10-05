package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Chiwawa extends SelectedDog {

    public Chiwawa() {
        description = "Chiwawa";
    }

    @Override
    public double cost() {
        return 1.28;
    }
}
