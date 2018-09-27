package com.github.vinifkroth.cloudnative.tema3.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;

import com.github.vinifkroth.cloudnative.tema3.dto.OperationDTO;
import com.github.vinifkroth.cloudnative.tema3.model.Operation;
import com.github.vinifkroth.cloudnative.tema3.service.Calculator;
import com.github.vinifkroth.cloudnative.tema3.singleton.AppContextSingleton;

@Path("calculator")
public class CalculatorController {
	ApplicationContext appContext = AppContextSingleton.getInstance();
	Calculator calculator = (Calculator) appContext.getBean("calculator");

	@Path("/ping")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "pongv1.2";
	}

	@Path("/record")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRecord() {
		StringBuilder str = new StringBuilder();
		str.append("Operations Results Record: \n");
		for (Operation operation : calculator.getResultsRecord()) {
			str.append(operation.calculate())
			   .append("\n");
		}
		return str.toString().equals("Operations Results Record: \n") ? "No results record available yet :("
				: str.toString();
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