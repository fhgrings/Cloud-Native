package com.github.vinifkroth.cloudnative.tema5.controller;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.github.vinifkroth.cloudnative.tema5.exception.InvalidVehicleException;
import com.github.vinifkroth.cloudnative.tema5.exception.NotEnoughMoneyException;
import com.github.vinifkroth.cloudnative.tema5.service.TollService;
import com.github.vinifkroth.cloudnative.tema5.singleton.AppContextSingleton;

@Path("")
public class TollController {

	private TollService tollService = (TollService) AppContextSingleton.getInstance().getBean("tollService");

	@Path("/ping")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ping() {
		return "pong1.6";
	}

	@Path("")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPrices() {
		return tollService.getPrices();
	}

	@Path("/charge")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String chargeFee(@DefaultValue("0") @QueryParam("vehicle") Integer vehicle,
			@DefaultValue("0") @QueryParam("value") double money, @DefaultValue("0") @QueryParam("axis") int axis) {
		try {
			return "Fee paid, you may go along, and the change is $:" + tollService.chargeFee(vehicle, money, axis);
		} catch (NotEnoughMoneyException | InvalidVehicleException e) {
			return e.getMessage();
		}
	}

}