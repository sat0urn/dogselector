package Decorator.SelectodDogs;

import Decorator.SelectedDog;

public class Pug extends SelectedDog {

    public Pug() {
        description = "Pug";
    }

    @Override
    public double cost() {
        return 1.35;
    }
}
