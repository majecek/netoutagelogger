package eu.chowaniok;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by marek on 06/11/14.
 */
public class Ping {

    @Getter @Setter private  long id;
    @Getter @Setter private  int year;
    @Getter @Setter private  int month;
    @Getter @Setter private  int day;
    @Getter @Setter private  int hour;
    @Getter @Setter private  int minute;

    public Ping(long id, int year, int month, int day, int hour, int minute) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
}
