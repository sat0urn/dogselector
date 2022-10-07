import Controllers.ClientController;
import Controllers.UserController;
import Decorator.*;
import Decorator.SelectodDogs.*;
import Models.Client;
import Models.User;
import Observer.DogAcquisition;
import SpeciesOfDogs.Dog;

import Behaviors_and_Realizations.Intellect_realizations.*;
import Behaviors_and_Realizations.lifestyle_realizations.*;
import Behaviors_and_Realizations.mood_realizations.*;
import Behaviors_and_Realizations.size_realizations.*;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static UserController userController = new UserController();
    static boolean isLogin = false;
    static boolean adminIsLogin = false;
    static User user;
    static DogAcquisition dogAcquisition = new DogAcquisition();
    static SelectedDog currentSelectedDog = null;
    static List<SelectedDog> selectedDogList = Arrays.asList(
            new Akita_Inu(), new Beagle(), new Boxer(), new Bulldog(),
            new Chiwawa(), new Corgi(), new Dalmatian(), new Doberman(),
            new Haski(), new Labrador(), new Puddle(), new Pug(),
            new Samoed(), new Spitz(), new Tax());

    public static void main(String[] args) throws SQLException {
        Dog dog = new Dog() {
            @Override
            public void display() {
            }

            @Override
            public String getDogSpeecy() {
                return null;
            }
        };

        while (true) {
            if (!isLogin && !adminIsLogin) {
                // LOGIN/REGISTER
                System.out.println("-----------------------------------------------------");
                System.out.println("           Do you have an account already?           ");
                System.out.println("YES - y | NO - n | Leave - any character (!= y, != n)");
                System.out.println("-----------------------------------------------------");
                String hasAccount = scan.next();
                if (hasAccount.equalsIgnoreCase("y")) {
                    logIn();
                    if (!userController.getAdminIsLogin())
                        isLogin = userController.getLoginStatement();
                    else
                        adminIsLogin = userController.getAdminIsLogin();
                } else if (hasAccount.equalsIgnoreCase("n")) {
                    registerIn();
                    isLogin = userController.getLoginStatement();
                } else {
                    break;
                }
            } else if (isLogin && !adminIsLogin) {
                while (true) {
                    if (isLogin) {
                        System.out.println("_----------------------------------------_");
                        System.out.println("            Hello " + user.getFirstname() + " " + user.getLastname() + "!");
                        System.out.println("|  DOG-SELECTOR APP | Messages | Logout  |");
                        System.out.println("|         2         |     1    |    0    |");
                        System.out.println("_----------------------------------------_");
                        String menu = scan.next();
                        // DOG-SELECTOR
                        if (menu.equalsIgnoreCase("2")) {
                            System.out.println("_--------------------DOG-SELECTOR-(DG)--------------------_");
                            System.out.println("(DG) Welcome to DogSelector!\nYou need to answer a couple of questions regarding dog behavior");
                            System.out.println("(DG) Let's start!");
                            System.out.println("_---------------------------------------------------------_");
                            while (true) {
                                boolean gate = false;
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("(DG) Do you prefer more active, aggressive or calm dog?" +
                                        "\nActive - 1, Aggressive - 2, Calm - 3");
                                System.out.println("-----------------------------------------------------------");
                                String mood = scan.next();
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
                                    default -> System.out.println("(DG) You need to choose between 1 and 3");
                                }
                                if (gate) break;
                            }
                            while (true) {
                                boolean gate = false;
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("(DG) Pick size of dog that you prefer" +
                                        "\nBig - 1, Medium - 2, Small - 3");
                                System.out.println("-----------------------------------------------------------");
                                String size = scan.next();
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
                                    default -> System.out.println("(DG) You need to choose between 1 and 3");
                                }
                                if (gate) break;
                            }
                            while (true) {
                                boolean gate = false;
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("(DG) Do you like street or domestic animal?" +
                                        "\nStreet - 1, Domestic - 2");
                                System.out.println("-----------------------------------------------------------");
                                String lifestyle = scan.next();
                                switch (lifestyle) {
                                    case "1" -> {
                                        dog.setLifestyleBehavior(new Street());
                                        gate = true;
                                    }
                                    case "2" -> {
                                        dog.setLifestyleBehavior(new Domestic());
                                        gate = true;
                                    }
                                    default -> System.out.println("(DG) You need to choose between 1 and 2");
                                }
                                if (gate) break;
                            }
                            while (true) {
                                boolean gate = false;
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("(DG) Should dog be trained or not trained?" +
                                        "\nTrained - 1, NoTrained - 2");
                                System.out.println("-----------------------------------------------------------");
                                String intellect = scan.next();
                                switch (intellect) {
                                    case "1" -> {
                                        dog.setIntellectBehavior(new Trained());
                                        gate = true;
                                    }
                                    case "2" -> {
                                        dog.setIntellectBehavior(new NoTrained());
                                        gate = true;
                                    }
                                    default -> System.out.println("(DG) You need to choose between 1 and 2");
                                }
                                if (gate) break;
                            }

                            System.out.println("-----------------------------------------------------------");
                            dog.defineTypeOfDog();
                            System.out.println("-----------------------------------------------------------");

                            boolean alreadyHasThatDog = false;
                            if (dog.getDogIs() != null) {
                                alreadyHasThatDog = ClientController.hasThatDog(
                                        user.getFirstname() + " " + user.getLastname(),
                                        dog.getDogIs().getDogSpeecy());
                            }
                            if (alreadyHasThatDog) {
                                System.out.println();
                                System.out.println("--------------------------------");
                                System.out.println("|                              |");
                                System.out.println("|  You already have that dog!  |");
                                System.out.println("|                              |");
                                System.out.println("--------------------------------");
                                break;
                            }

                            // DOG-BUY
                            if (dog.getDogIs() != null) {
                                System.out.println();
                                System.out.println("_--------------------DOG-BUY-SERVICES-------------------_");
                                System.out.println("| Do you want to buy a " + dog.getDogIs().getDogSpeecy() + " dog?");
                                System.out.println("| YES - y | NO - q or any character");
                                System.out.println("---------------------------------------------------------");
                                String buyingDog = scan.next();

                                if (buyingDog.equalsIgnoreCase("y")) {
                                    System.out.println();
                                    System.out.println("_---------------------------------------------------------_");
                                    System.out.println("|Ok, we will send you a message with dog acquisition time!|");
                                    System.out.println("|-----------------(Check your \"messages\")-----------------|");
                                    System.out.println("_---------------------------------------------------------_");
                                    System.out.println();

                                    userController.sendMessageToAdmin(user, dog.getDogIs().getDogSpeecy());

                                    for (SelectedDog selectedDog : selectedDogList) {
                                        if (selectedDog.description.equals(dog.getDogIs().getDogSpeecy())) {
                                            currentSelectedDog = selectedDog;
                                            break;
                                        }
                                    }

                                    System.out.println("| What kind of services do you want to take for your selected " +
                                            dog.getDogIs().getDogSpeecy() + "?");

                                    System.out.println("| -----------------------------------------------------------");
                                    System.out.println("| 1) Deprivation of reproductive function");
                                    System.out.println("| YES - y | NO - q or any character");
                                    System.out.println("| -----------------------------------------------------------");
                                    String serviceDeprivation = scan.next();
                                    if (serviceDeprivation.equalsIgnoreCase("y")) {
                                        currentSelectedDog = new DepRecFunc(currentSelectedDog);
                                    }

                                    System.out.println("| -----------------------------------------------------------");
                                    System.out.println("| 2) Vaccination");
                                    System.out.println("| YES - y | NO - q or any character");
                                    System.out.println("| -----------------------------------------------------------");
                                    String serviceGrafted = scan.next();
                                    if (serviceGrafted.equalsIgnoreCase("y")) {
                                        currentSelectedDog = new Grafted(currentSelectedDog);
                                    }

                                    System.out.println("-----------------------------------------------------------");
                                    System.out.println("| Services: " + currentSelectedDog.getDescription() + "\n"
                                            + "Cost: $" + currentSelectedDog.cost());

                                    System.out.println("| Wait a message, our administration will send you an information later!");
                                }
                            }
                        } else if (menu.equalsIgnoreCase("1")) {
                            System.out.println("_--------------------MESSAGES-------------------_");
                            System.out.println("(U) Messages: ");
                            System.out.println("-------------------------------------------------------------------");
                            dogAcquisition.notifyObserver(user.getFirstname() + " " + user.getLastname());
                            System.out.println("-------------------------------------------------------------------");
                        } else if (menu.equalsIgnoreCase("0")) {
                            exit();
                        }
                    } else {
                        break;
                    }
                }
            } else if (adminIsLogin && !isLogin) {
                // ADMIN
                System.out.println("_----------------------------------------_");
                System.out.println("|              ADMIN ACCOUNT             |");
                System.out.println("|            MESSAGES | LOGOUT           |");
                System.out.println("|               m     |    0             |");
                System.out.println("_----------------------------------------_");
                String adminMenu = scan.next();
                if (adminMenu.equalsIgnoreCase("m")) {
                    String name, surname, dogBreed;
                    String client_id;
                    int id = 1;

                    String[] messages = (String[]) user.getMessages().getArray();
                    System.out.println("(A) Messages: ");
                    for (String message : messages) {
                        System.out.println(id + ". " + message);
                        id++;
                    }

                    Client client;

                    while (true) {
                        try {
                            System.out.print("(A) Client id: ");
                            client_id = scan.next();
                            String clientString = messages[Integer.parseInt(client_id) - 1];

                            String[] splittedClientString = clientString.split(" ");
                            name = splittedClientString[0];
                            surname = splittedClientString[1];
                            dogBreed = splittedClientString[5];

                            System.out.print("(A) Date (yyyy-MM-dd): ");
                            String date = scan.next();

                            String full_name = name + " " + surname;
                            client = new Client(full_name, dogBreed, date);
                            break;
                        } catch (Exception e) {
                            System.out.println("(A) ID issues or Wrong Date format!");
                        }
                    }

                    dogAcquisition.registerObserver(client);
                    ClientController clientController = new ClientController();
                    clientController.setServicesAndItsCost(client, currentSelectedDog.getDescription(), currentSelectedDog.cost());
                } else if (adminMenu.equalsIgnoreCase("0")) {
                    exit();
                }
            }
        }
    }

    public static void logIn() {
        String user_login, user_password;
        System.out.println("-----------------------------------------------------");
        System.out.println("(L) LOGIN");
        System.out.println("-----------------------------------------------------");
        System.out.print("(L) Login: ");
        user_login = scan.next();
        System.out.print("(L) Password: ");
        user_password = scan.next();

        user = new User(user_login, user_password);

        userController.login(user);

        user = userController.getUser(user);
    }

    public static void registerIn() {
        String user_firstname, user_lastname, user_login, user_password;
        System.out.println("-----------------------------------------------------");
        System.out.println("(R) REGISTRATION");
        System.out.println("-----------------------------------------------------");
        System.out.print("(R) Your name: ");
        user_firstname = scan.next();
        System.out.print("(R) Your surname: ");
        user_lastname = scan.next();
        System.out.print("(R) Login: ");
        user_login = scan.next();
        System.out.print("(R) Password: ");
        user_password = scan.next();

        user = new User(user_firstname, user_lastname, user_login, user_password);

        userController.register(user);
    }

    public static void exit() {
        userController.setLoginStatement(false);
        userController.setAdminIsLogin(false);
        isLogin = userController.getLoginStatement();
        adminIsLogin = userController.getAdminIsLogin();
    }
}
