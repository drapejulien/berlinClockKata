package fr.jdrape.kata.berlinclockkata.service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import fr.jdrape.kata.berlinclockkata.enumeration.EnumLampState;

@Service
public final class BerlinClockServiceImpl implements BerlinClockService {

    @Override
    public String convertDigitalToBerlin(final String time) {
        final int[] timeSplit = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
        final Integer hours = timeSplit[0];
        final Integer minutes = timeSplit[1];
        final Integer seconds = timeSplit[2];
        return String.join("", calculateSecondsLampRow(seconds), calculateFiveHoursRow(hours), calculateSingleHoursRow(hours), calculateFiveMinutesRow(minutes),
                calculateSingleMinutesRow(minutes));
    }

    /**
     * Calculate the 1st row : second
     * 
     * @param seconds
     *            : seconds in digital format time
     * @return : second in berlin clock format
     */
    private String calculateSecondsLampRow(final Integer seconds) {
        if (seconds % 2 == 0) {
            return EnumLampState.YELLOW.getCode();
        } else {
            return EnumLampState.OFF.getCode();
        }
    }

    /**
     * Calculate the 2nd row : 5 hours
     * 
     * @param hours
     *            : hours in digital format time
     * @return : 5 hours in berlin clock format
     */
    private String calculateFiveHoursRow(final Integer hours) {
        // Divide hours by 5 to know how many lamp need to be ON
        return calculateRow(hours / 5, EnumLampState.RED);
    }

    /**
     * Calculate the 3nd row : single hour
     * 
     * @param hours
     *            : hours in digital format time
     * @return : single hours in berlin clock format
     */
    private String calculateSingleHoursRow(final Integer hours) {
        return calculateRow(hours % 5, EnumLampState.RED);
    }

    /**
     * Calculate the hour row. RED if ON,
     * 
     * @param numberLampToOn
     *            : number of LAMP to switch ON
     * @return : berlin clock row.
     */
    private String calculateRow(final int numberLampToOn, final EnumLampState onState) {
        final StringBuilder row = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            if (i <= numberLampToOn) {
                row.append(onState.getCode());
            } else {
                row.append(EnumLampState.OFF.getCode());
            }
        }
        return row.toString();
    }

    /**
     * Calculate the 4th row : five minutes row.
     * 
     * @param minutes
     *            : minutes in digital format time
     * @return : berlin clock 5 minutes row.
     */
    private String calculateFiveMinutesRow(final Integer minutes) {
        final StringBuilder row = new StringBuilder();
        final int numberLampToOn = minutes / 5;
        for (int i = 1; i <= 11; i++) {
            if (i <= numberLampToOn) {
                // Each 3 lamp, it's RED
                if (i % 3 == 0) {
                    row.append(EnumLampState.RED.getCode());
                } else {
                    row.append(EnumLampState.YELLOW.getCode());
                }
            } else {
                row.append(EnumLampState.OFF.getCode());
            }
        }

        return row.toString();
    }

    /**
     * Calculate the 5th row : single minutes
     * 
     * @param minutes
     *            : minutes in digital format time
     * @return : single minutes in berlin clock format
     */
    private String calculateSingleMinutesRow(final Integer minutes) {
        return calculateRow(minutes % 5, EnumLampState.YELLOW);
    }

}
