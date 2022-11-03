package SpeciesOfDogs;

import Behaviors_and_Realizations.*;
import Controllers.DogController;

import java.util.Arrays;
import java.util.List;

public abstract class Dog {

    public abstract void display();
    public abstract String getDogSpeecy();

    private IntellectBehavior intellectBehavior;
    private SizeBehavior sizeBehavior;
    private MoodBehavior moodBehavior;
    private LifestyleBehavior lifestyleBehavior;
    private Dog dogIs;

    public void defineTypeOfDog() {
        List<Dog> dogList = Arrays.asList(
                new Akita_Inu(), new Basset_Hound(), new Beagle(), new Boston_Terrier(),
                new Boxer(), new Bullmastiff(), new Bulldog(), new Caucasion_Shephard(),
                new Chiwawa(), new Chow_Chow(), new Corgi(), new Dalmatian(), new Doberman(),
                new German_Shephard(), new German_Shorthaired_Pointer(), new Ghanaian(), new Golden_Retriever(),
                new Great_Dane(), new Husky(), new Irish_Water_Spaniel(), new Labrador(), new Mixed_Breed_1(),
                new Mixed_Breed_2(), new Neapolitan_Mastiff(), new Norwegian_Elkhound(), new Norwegian_Lundehund(),
                new Pomeranian(), new Pooch(), new Puddle(), new Pug(), new Samoyed(), new Spaniel(),
                new Tax(), new Tibet_Mastiff(), new Tosa_Inu(), new Yorkshire_Terrier()
        );

        String dogBreed = DogController.getDogName(sizeBehavior, moodBehavior, lifestyleBehavior, intellectBehavior);

        for (Dog dog : dogList) {
            if (dog.getDogSpeecy().equals(dogBreed)) {
                dog.display();
                dogIs = dog;
                return;
            }
        }
        System.out.println("Sorry, we don't have that dog...");
    }

    public void setIntellectBehavior(IntellectBehavior intellectBehavior) {
        this.intellectBehavior = intellectBehavior;
    }
    public String getIntellectBehavior() {
        return this.intellectBehavior.intellect();
    }

    public void setSizeBehavior(SizeBehavior sizeBehavior) {
        this.sizeBehavior = sizeBehavior;
    }
    public String getSizeBehavior() {
        return this.sizeBehavior.size();
    }

    public void setMoodBehavior(MoodBehavior moodBehavior) {
        this.moodBehavior = moodBehavior;
    }
    public String getMoodBehavior() {
        return this.moodBehavior.mood();
    }

    public void setLifestyleBehavior(LifestyleBehavior lifestyleBehavior) {
        this.lifestyleBehavior = lifestyleBehavior;
    }
    public String getLifestyleBehavior() {
        return this.lifestyleBehavior.lifestyle();
    }

    public Dog getDogIs() { return this.dogIs; }
}
