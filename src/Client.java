import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Client implements Observer {
    private String dogBayer;
    private String dogSpeecy;
    private String date;

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public Client(String dogBayer, String dogSpeecy) {
        this.dogBayer = dogBayer;
        this.dogSpeecy = dogSpeecy;
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH,14);
        this.date = dateFormat.format(calendar.getTime());
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
