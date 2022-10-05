package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import Observer.Observer;

public class Client implements Observer {
    private String dogBayer;
    private String dogSpeecy;
    private String date;

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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

    public String getDogBayer() {
        return this.dogBayer;
    }

    public String getDogSpeecy() { return this.dogSpeecy; }

    public String getDate() { return this.date; }
}
