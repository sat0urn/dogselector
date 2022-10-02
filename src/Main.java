import SpeciesOfDogs.Dog;
import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Big;
import Behaviors_and_Realizations.size_realizations.Medium;
import Behaviors_and_Realizations.size_realizations.Small;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dog dog = new Dog() {
            @Override
            public void display() {

            }

            @Override
            public String getDogSpeecy() {
                return null;
            }
        };

        System.out.println("Welcome to DogSelector!\nYou need to answer a couple of questions regarding dog behavior");
        System.out.println("Let's start!");

        while (true) {
            while (true) {
                boolean gate = false;
                System.out.println("----------------------------------------");
                System.out.println("Do you prefer more active, aggressive or calm dog?" +
                        "\nActive - 1, Aggressive - 2, Calm - 3");
                System.out.println("----------------------------------------");
                String mood = scan.nextLine();
                switch (mood) {
                    case "1" -> {
                        dog.setMoodBehavior(new Active());
                        gate = true;
                    }
                    case "2" -> {
                        dog.setMoodBehavior(new Aggressive());
                        gate = true;
                    }
                    case "3" -> {
                        dog.setMoodBehavior(new Calm());
                        gate = true;
                    }
                    default -> System.out.println("You need to choose between 1 and 3");
                }
                if (gate) break;
            }
            while (true) {
                boolean gate = false;
                System.out.println("----------------------------------------");
                System.out.println("Pick size of dog that you prefer" +
                        "\nBig - 1, Medium - 2, Small - 3");
                System.out.println("----------------------------------------");
                String size = scan.nextLine();
                switch (size) {
                    case "1" -> {
                        dog.setSizeBehavior(new Big());
                        gate = true;
                    }
                    case "2" -> {
                        dog.setSizeBehavior(new Medium());
                        gate = true;
                    }
                    case "3" -> {
                        dog.setSizeBehavior(new Small());
                        gate = true;
                    }
                    default -> System.out.println("You need to choose between 1 and 3");
                }
                if (gate) break;
            }
            while (true) {
                boolean gate = false;
                System.out.println("----------------------------------------");
                System.out.println("Do you like street or domestic animal?" +
                        "\nStreet - 1, Domestic - 2");
                System.out.println("----------------------------------------");
                String lifestyle = scan.nextLine();
                switch (lifestyle) {
                    case "1" -> {
                        dog.setLifestyleBehavior(new Street());
                        gate = true;
                    }
                    case "2" -> {
                        dog.setLifestyleBehavior(new Domestic());
                        gate = true;
                    }
                    default -> System.out.println("You need to choose between 1 and 2");
                }
                if (gate) break;
            }
            while (true) {
                boolean gate = false;
                System.out.println("----------------------------------------");
                System.out.println("Should dog be trained or not trained?" +
                        "\nTrained - 1, NoTrained - 2");
                System.out.println("----------------------------------------");
                String intellect = scan.nextLine();
                switch (intellect) {
                    case "1" -> {
                        dog.setIntellectBehavior(new Trained());
                        gate = true;
                    }
                    case "2" -> {
                        dog.setIntellectBehavior(new NoTrained());
                        gate = true;
                    }
                    default -> System.out.println("You need to choose between 1 and 2");
                }
                if (gate) break;
            }

            System.out.println("----------------------------------------");
            dog.defineTypeOfDog();
            System.out.println("----------------------------------------");

            if (dog.getDogIs() != null) {
                System.out.println("Do you want to buy a " + dog.getDogIs().getDogSpeecy() + " dog?");
                System.out.println("YES - y | NO - q or any character");
                String buyingDog = scan.nextLine();
                if (buyingDog.equalsIgnoreCase("y")) {
                    System.out.println("----------------------------------------");
                    System.out.println("Please can you write your personal data");
                    System.out.println("----------------------------------------");

                    System.out.print("First name: ");
                    String first_name = scan.nextLine();
                    System.out.print("Last name: ");
                    String last_name = scan.nextLine();

                    System.out.println("----------------------------------------");
                    DogAcquisition dogAcquisition = new DogAcquisition();
                    String user_name = last_name + " " + first_name;
                    Client client = new Client(user_name, dog.getDogIs().getDogSpeecy());

                    dogAcquisition.registerObserver(client);
                    dogAcquisition.notifyObservers();
                }
            }

            System.out.println("----------------------------------------");
            System.out.println("Continue? \nYES - y, NO - q or any character");
            String exit = scan.nextLine();
            if (!exit.equalsIgnoreCase("y")) break;
        }
    }
}
