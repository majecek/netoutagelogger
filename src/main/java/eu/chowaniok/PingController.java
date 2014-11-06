package eu.chowaniok;

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



        Calendar cal = Calendar.getInstance();
        Ping ping = new Ping(0, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));

        int saved = pingRepository.save(ping);

//        return null;
//        return new Ping(counter.incrementAndGet(),
//            String.format(template, name), year, month, day, hour, minute);
    }
}
