package Models;

import Observer.Observer;

public class Client implements Observer {
    private String dogBayer;
    private String dogSpeecy;
    private String date;

    public Client() {}

    public Client(String dogBayer, String dogSpeecy, String date) {
        this.dogBayer = dogBayer;
        this.dogSpeecy = dogSpeecy;
        this.date = date;
    }

    @Override
    public void update() {
        System.out.println(this.dogBayer + " is waiting for " +
                this.dogSpeecy + ", date to pickup is: " + this.date);
    }

    @Override
    public String getName() {
        return getDogBayer();
    }

    @Override
    public String getDogBreed() {
        return getDogSpeecy();
    }

    public String getDogBayer() {
        return this.dogBayer;
    }

    public String getDogSpeecy() { return this.dogSpeecy; }

    public String getDate() { return this.date; }
}
