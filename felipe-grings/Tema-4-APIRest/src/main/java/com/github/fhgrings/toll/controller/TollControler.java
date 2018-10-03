package com.github.fhgrings.toll.controller;

import com.github.fhgrings.toll.config.TollConfig;
import com.github.fhgrings.toll.app.Toll;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("toll")
public class TollControler {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TollConfig.class);
    Toll toll = applicationContext.getBean(Toll.class);

    @GET
    @Path("/calculate")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculate(@QueryParam("type") String type, @DefaultValue("0")@QueryParam("axis") int axis, @QueryParam("money") double money ) {
        try {
            return String.valueOf(toll.calculate(type,axis,money));
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    @GET
    @Path("/pricelist")
    @Produces(MediaType.TEXT_PLAIN)
    public String price() {
        return toll.priceList();
    }
}
