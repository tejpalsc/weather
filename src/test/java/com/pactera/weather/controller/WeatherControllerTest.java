package com.pactera.weather.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WeatherControllerTest {
		

    @InjectMocks
    WeatherController weatherController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(weatherController).build();
    }
	
	@Test
	public void testWeatherDetails() throws Exception {
;
	    mockMvc.perform(get("/details?city=Sydney")).andExpect(status().is2xxSuccessful());
	}
	
	
	@Test
	public void testLocation() throws Exception {
		mockMvc.perform(get("/cities")).andExpect(status().isOk());
	}
	
	
}
