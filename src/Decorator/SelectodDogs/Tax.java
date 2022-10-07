package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Tax extends SelectedDog {

    public Tax() {
        description = "Tax";
    }

    @Override
    public double cost() {
        return 1.38;
    }
}
