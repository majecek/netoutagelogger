package eu.chowaniok;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by marek on 06/11/14.
 */
@RestController
public class PingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PingRepository pingRepository;


    @RequestMapping("/ping")
    public void savePing() {

        System.out.println("SAVING PING !!!!!!!!!!!");

        Calendar cal = Calendar.getInstance();
        DateTime dt = new DateTime();
        DateTimeZone zone = DateTimeZone.forID("Europe/Prague");

        Ping ping = new Ping(0, dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), dt.getHourOfDay(), dt.getMinuteOfDay());

        int saved = pingRepository.save(ping);

//        return null;
//        return new Ping(counter.incrementAndGet(),
//            String.format(template, name), year, month, day, hour, minute);
    }
}
