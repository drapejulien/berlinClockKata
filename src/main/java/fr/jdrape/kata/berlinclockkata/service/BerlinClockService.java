package fr.jdrape.kata.berlinclockkata.service;

/**
 * Service for BerlinClock.
 * 
 * @author jdrape
 *
 */
public interface BerlinClockService {

    /**
     * Convert a digital time HH:mm:ss to a Berlin clock time.
     * 
     * @param time
     *            : digital time to convert
     * @return the berlin clock time
     */
    String convertDigitalToBerlin(final String time);
}
