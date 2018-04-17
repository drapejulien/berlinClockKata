package fr.jdrape.kata.berlinclockkata.controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.jdrape.kata.berlinclockkata.service.BerlinClockService;

@RestController
@RequestMapping("/clockConverter")
@Validated
public class ClockController {

    private static final String TIME_PATTERN = "^(2[0-3]|[01]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])$";

    @Autowired
    private BerlinClockService service;

    /**
     * Convert digital time HH:mm:ss to Berlin Time.
     * 
     * @param time
     *            : time to convert
     * @return Berlin Time
     */
    @RequestMapping(path = "digitalToBerlin", method = RequestMethod.GET)
    public String digitalToBerlin(
            @Valid @Pattern(regexp = TIME_PATTERN, message = "Param 'time' must be a true time") @RequestParam(value = "time", required = true) final String time) {
        return service.convertDigitalToBerlin(time);
    }

}
