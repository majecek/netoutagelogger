package eu.chowaniok;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by marek on 06/11/14.
 */
@RestController
public class PingRestController {

    @Autowired
    private PingRepository pingRepository;


    @RequestMapping("/ping")
    public void savePing() {
        DateTime dt = new DateTime().withZone(DateTimeZone.forID("Europe/Prague"));
        System.out.println(dt);
        Ping ping = new Ping(0, dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), dt.getHourOfDay(), dt.getMinuteOfHour());
        int saved = pingRepository.save(ping);
    }
}
