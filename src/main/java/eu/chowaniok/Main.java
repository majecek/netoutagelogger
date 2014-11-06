package eu.chowaniok;

/**
 * Created by marek on 06/11/14.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@Controller
public class Main extends SpringBootServletInitializer {

    @Autowired
    protected JdbcTemplate jdbc;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        Main m = new Main();
        m.jdbc.execute("drop table pings if exists");
        m.jdbc.execute("create table pings(" +
            "id serial, year INT , month INT , day INT , hour INT , minute INT )");


    }

}
