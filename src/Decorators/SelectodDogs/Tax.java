package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Tax extends SelectedDog {

    public Tax() {
        description = "Tax";
    }

    @Override
    public double cost() {
        return 1.38;
    }
}
