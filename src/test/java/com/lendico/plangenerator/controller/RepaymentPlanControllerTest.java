package com.lendico.plangenerator.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * The Class RepaymentPlanControllerTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class RepaymentPlanControllerTest {

  /** The mock mvc. */
  @Autowired
  private MockMvc mockMvc;

  /**
   * Test generate plan.
   *
   * @throws Exception the exception
   */
  @Test
  public void testGeneratePlan() throws Exception {
    String request =
        "{\"loanAmount\": \"5000\",\"nominalRate\": \"5.0\",\"duration\": 24,\"startDate\": \"2018-01-01T00:00:01Z\"}";
    mockMvc
        .perform(MockMvcRequestBuilders.post("/generate-plan").content(request)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(24)));
  }


  /**
   * Test generate plan without required parameters.
   *
   * @throws Exception the exception
   */
  @Test
  public void testGeneratePlanWithoutRequiredParameters() throws Exception {
    String request = "{\"loanAmount\": \"5000\"}";
    mockMvc
        .perform(MockMvcRequestBuilders.post("/generate-plan").content(request)
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(print()).andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.timestamp", is(notNullValue())))
        .andExpect(jsonPath("$.status", is(400))).andExpect(jsonPath("$.errors").isArray())
        .andExpect(jsonPath("$.errors", hasSize(3)))
        .andExpect(jsonPath("$.errors", hasItem("nominalRate is Mandatory")))
        .andExpect(jsonPath("$.errors", hasItem("duration is Mandatory")))
        .andExpect(jsonPath("$.errors", hasItem("startDate is Mandatory")));
  }
}
