package com.github.fhgrings.calculator.app;


import com.github.fhgrings.calculator.config.AppConfig;
import com.github.fhgrings.calculator.operations.Calculator;
import com.sun.jersey.spi.resource.Singleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Singleton
@Path("com/github/fhgrings/calculator")
public class CalculatorControler {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    Calculator calculator = (Calculator) applicationContext.getBean("com/github/fhgrings/calculator");


    @GET
    @Path("/calculate")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculate(@QueryParam("value1") double value1, @QueryParam("value2") double value2, @QueryParam("operator") String operator) {
        return calculator.finishCalculation(value1,value2,operator);
    }

    @Path("/historic")
    @Produces(MediaType.TEXT_PLAIN)
    public String listHistoric(){
        return calculator.getMapHistory();
    }

}
