package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Labrador extends SelectedDog {

    public Labrador() {
        description = "Labrador";
    }

    @Override
    public double cost() {
        return 1.33;
    }
}
