package fr.jdrape.kata.berlinclockkata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class
 * 
 * @author jdrape
 *
 */
@SpringBootApplication(scanBasePackages = "fr.jdrape.kata.berlinclockkata")
public class BerlinClockKataLauncher {

    public static void main(final String[] args) {
        // start spring boot application
        SpringApplication.run(BerlinClockKataLauncher.class, args);
    }
}
