package com.lendico.plangenerator.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lendico.plangenerator.model.Repayment;
import com.lendico.plangenerator.model.RepaymentPlan;
import com.lendico.plangenerator.model.RepaymentPlanRequest;
import com.lendico.plangenerator.service.RepaymentService;

/**
 * The Class RepaymentPlanController.
 */
@Controller
@RequestMapping("/generate-plan")
public class RepaymentPlanController {

  /** The service. */
  @Autowired
  private RepaymentService service;

  /**
   * Generate plan.
   *
   * @param request the request
   * @return the list
   */
  @PostMapping
  @ResponseBody
  public List<Repayment> generatePlan(@Valid @RequestBody RepaymentPlanRequest request) {
    RepaymentPlan plan = service.generatePlan(request);
    return plan.getRepayments();

  }

}
