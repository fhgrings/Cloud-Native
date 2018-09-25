package com.github.vinifkroth.cloudnative.tema1.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.vinifkroth.cloudnative.tema1.app.AppConfig;
import com.github.vinifkroth.cloudnative.tema1.dto.OperationDTO;
import com.github.vinifkroth.cloudnative.tema1.service.Calculator;

@Path("calculator")
public class CalculatorController {
	ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
	Calculator calculator = (Calculator) appContext.getBean("calculator");

	@Path("/ping")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "pong1.1";
	}

	@Path("/calculate")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String calculate(OperationDTO operation) {
		try {
			return Double.toString(calculator.calculate(operation.getFirstElement(), operation.getSecondElement(),
					operation.getOperator()));
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}