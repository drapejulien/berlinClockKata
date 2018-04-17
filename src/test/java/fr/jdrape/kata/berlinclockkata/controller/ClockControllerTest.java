package fr.jdrape.kata.berlinclockkata.controller;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import fr.jdrape.kata.berlinclockkata.service.BerlinClockService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ClockController.class, secure = false)
public class ClockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BerlinClockService berlinClockService;

    @Test
    public void getBerlinClockTime() throws Exception {
        Mockito.when(berlinClockService.convertDigitalToBerlin(Mockito.anyString())).thenReturn("0RYRYRY0RY");
        final RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clockConverter/digitalToBerlin").param("time", "00:00:00")
                .accept(MediaType.APPLICATION_JSON);
        final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        final String expected = "0RYRYRY0RY";
        Assert.assertEquals(expected, result.getResponse().getContentAsString());
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void getBerlinClockTimeWithoutParam() throws Exception {
        Mockito.when(berlinClockService.convertDigitalToBerlin(Mockito.anyString())).thenReturn("0RYRYRY0RY");
        final RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clockConverter/digitalToBerlin").accept(MediaType.APPLICATION_JSON);
        final MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
    }

    @Test(expected = ConstraintViolationException.class)
    public void getBerlinClockTimeBadPattern() throws Throwable {
        Mockito.when(berlinClockService.convertDigitalToBerlin(Mockito.anyString())).thenReturn("0RYRYRY0RY");
        final RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/clockConverter/digitalToBerlin").param("time", "1A:00:00")
                .accept(MediaType.APPLICATION_JSON);
        try {
            mockMvc.perform(requestBuilder).andReturn();
        } catch (final Exception e) {
            throw e.getCause();
        }
    }

}
