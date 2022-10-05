package Decorators.SelectodDogs;

import Decorators.SelectedDog;

public class Pug extends SelectedDog {

    public Pug() {
        description = "Pug";
    }

    @Override
    public double cost() {
        return 1.35;
    }
}
