package com.healthcare.enrolleestracking.controller;

import com.healthcare.enrolleestracking.service.EnrolleeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class EntrolleeControllerTest {
    private MockMvc mockMvc;
    @Mock
    private EnrolleeService enrolleeService;
    @InjectMocks
    EnrolleeController enrolleeController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(enrolleeController).build();
    }
    @Test
    public void getEnrollee() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/registration/v1/enrollee/1/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    @Test
    public void deleteEnrollee() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/registration/v1/enrollee/1/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

    }

}
