package SpeciesOfDogs;

import Behaviors_and_Realizations.*;

public abstract class Dog {
    private final String BIG = "BIG";
    private final String MEDIUM = "MEDIUM";
    private final String SMALL = "SMALL";
    private final String CALM = "CALM";
    private final String AGGRESSIVE = "AGGRESSIVE";
    private final String ACTIVE = "ACTIVE";
    private final String TRAINED = "TRAINED";
    private final String NOTRAINED = "NOTRAINED";
    private final String DOMESTIC = "DOMESTIC";
    private final String STREET = "STREET";

    public abstract void display();
    public abstract String getDogSpeecy();

    private IntellectBehavior intellectBehavior;
    private SizeBehavior sizeBehavior;
    private MoodBehavior moodBehavior;
    private LifestyleBehavior lifestyleBehavior;
    private Dog dogIs;

    public void defineTypeOfDog() {
        if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(BIG) &&
            moodBehavior.mood().equals(CALM) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Labrador();
            new Labrador().display();
        }
        else if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(MEDIUM) &&
                moodBehavior.mood(ACTIVE) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Beagle();
            new Beagle().display();
        }
        else if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(MEDIUM) &&
                moodBehavior.mood(CALM) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Corgi();
            new Corgi().display();
        }
        else if (intellectBehavior.intellect(NOTRAINED) && sizeBehavior.size(SMALL) &&
                moodBehavior.mood(AGGRESSIVE) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Spitz();
            new Spitz().display();
        }
        else if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(BIG) &&
                moodBehavior.mood(AGGRESSIVE) && lifestyleBehavior.lifestyle(STREET)) {
            dogIs = new Doberman();
            new Doberman().display();
        }
        else if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(BIG) &&
                moodBehavior.mood(ACTIVE) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Haski();
            new Haski().display();
        }
        else if (intellectBehavior.intellect(NOTRAINED) && sizeBehavior.size(BIG) &&
                moodBehavior.mood(ACTIVE) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Samoed();
            new Samoed().display();
        }
        else if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(BIG) &&
                moodBehavior.mood(CALM) && lifestyleBehavior.lifestyle(STREET)) {
            dogIs = new Akita_Inu();
            new Akita_Inu().display();
        }
        else if (intellectBehavior.intellect(NOTRAINED) && sizeBehavior.size(MEDIUM) &&
                moodBehavior.mood(CALM) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Puddle();
            new Puddle().display();
        }
        else if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(MEDIUM) &&
                moodBehavior.mood(ACTIVE) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Dalmatian();
            new Dalmatian().display();
        }
        else if (intellectBehavior.intellect(NOTRAINED) && sizeBehavior.size(MEDIUM) &&
                moodBehavior.mood(AGGRESSIVE) && lifestyleBehavior.lifestyle(STREET)) {
            dogIs = new Boxer();
            new Boxer().display();
        }
        else if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(MEDIUM) &&
                moodBehavior.mood(AGGRESSIVE) && lifestyleBehavior.lifestyle(STREET)) {
            dogIs = new Bulldog();
            new Bulldog().display();
        }
        else if (intellectBehavior.intellect(NOTRAINED) && sizeBehavior.size(SMALL) &&
                moodBehavior.mood(CALM) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Pug();
            new Pug().display();
        }
        else if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(SMALL) &&
                moodBehavior.mood(AGGRESSIVE) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Chiwawa();
            new Chiwawa().display();
        }
        else if (intellectBehavior.intellect(TRAINED) && sizeBehavior.size(SMALL) &&
                moodBehavior.mood(ACTIVE) && lifestyleBehavior.lifestyle(DOMESTIC)) {
            dogIs = new Tax();
            new Tax().display();
        }
        else {
            dogIs = null;
            System.out.println("We don't have that dog, sorry...");
        }
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
