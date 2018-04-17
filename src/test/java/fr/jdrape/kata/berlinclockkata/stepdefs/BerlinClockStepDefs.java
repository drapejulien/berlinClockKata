package fr.jdrape.kata.berlinclockkata.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.jdrape.kata.berlinclockkata.service.BerlinClockService;
import fr.jdrape.kata.berlinclockkata.service.BerlinClockServiceImpl;

public class BerlinClockStepDefs {

    private BerlinClockService berlinClockService;

    private String berlinClockTime;

    @Given("^I have started the converter$")
    public void I_have_started_the_converter() {
        berlinClockService = new BerlinClockServiceImpl();
    }

    @When("^I enter ([^\"]*)$")
    public void I_enter_time(final String time) {
        this.berlinClockTime = berlinClockService.convertDigitalToBerlin(time);
    }

    @Then("^([^\"]*) is returned for the single minutes row$")
    public void row_is_returned_for_the_single_minutes_row(final String row) {
        assertThat(berlinClockTime.substring(20, 24)).isEqualTo(row);
    }

    @Then("^([^\"]*) is returned for the five minutes row$")
    public void row_is_returned_for_the_five_minutes_row(final String row) {
        assertThat(berlinClockTime.substring(9, 20)).isEqualTo(row);
    }

    @Then("^([^\"]*) is returned for the single hours row$")
    public void row_is_returned_for_the_single_hours_row(final String row) {
        assertThat(berlinClockTime.substring(5, 9)).isEqualTo(row);
    }

    @Then("^([^\"]*) is returned for the five hours row$")
    public void row_is_returned_for_the_five_hours_row(final String row) {
        assertThat(berlinClockTime.substring(1, 5)).isEqualTo(row);
    }

    @Then("^([^\"]*) is returned for the seconds lamp$")
    public void lamp_is_returned_for_the_seconds_lamp(final String lamp) {
        assertThat(berlinClockTime.substring(0, 1)).isEqualTo(lamp);
    }

    @Then("^([^\"]*) is returned$")
    public void clock_is_returned(final String clock) {
        assertThat(berlinClockTime).isEqualTo(clock);
    }
}
