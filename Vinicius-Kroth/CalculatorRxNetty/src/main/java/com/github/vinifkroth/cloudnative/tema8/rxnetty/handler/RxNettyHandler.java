package com.github.vinifkroth.cloudnative.tema8.rxnetty.handler;

import com.github.vinifkroth.cloudnative.tema8.service.Calculator;

import java.util.List;

import com.github.vinifkroth.cloudnative.tema8.model.Operation;
import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import rx.Observable;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {
	private final String healthCheckUri;
	private final HealthCheckEndpoint healthCheckEndpoint;
	private final Injector injector;
	private final Calculator calculator;

	public RxNettyHandler(String healthCheckUri, HealthCheckEndpoint healthCheckEndpoint) {
		this.healthCheckUri = healthCheckUri;
		this.healthCheckEndpoint = healthCheckEndpoint;
		injector = Guice.createInjector();
		calculator = injector.getInstance(Calculator.class);
	}

	@Override
	public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
		String uri = request.getUri();
		if (uri.startsWith(healthCheckUri)) {
			return healthCheckEndpoint.handle(request, response);
		} else if (uri.startsWith("/record")) {
			return response.writeStringAndFlush(new Gson().toJson(record(calculator.getResultsRecord())));
		} else if (uri.startsWith("/calculate")) {
			return calculate(response, uri);
		} else {
			response.setStatus(HttpResponseStatus.NOT_FOUND);
			return response.close();
		}
	}

	private Observable<Void> calculate(HttpServerResponse<ByteBuf> response, String uri) {
		String[] parameters = uri.substring(uri.indexOf("/", 1) + 1).split("/");
		if (parameters.length != 3) {
			response.setStatus(HttpResponseStatus.BAD_REQUEST);
			return response.writeStringAndFlush("Invalid endpoint format, please check the used syntax.");
		} else {
			String operation = parameters[0];
			Double firstElement = Double.parseDouble(parameters[1]);
			Double secondElement = Double.parseDouble(parameters[2]);
			try {
				return response.writeStringAndFlush(
						"Result:" + calculator.calculate(firstElement, secondElement, operation) + "");
			} catch (Exception exception) {
				return response.writeStringAndFlush(exception.getMessage());
			}
		}
	}

	private String record(List<Operation> resultsRecord) {
		StringBuilder str = new StringBuilder();
		for (Operation operation : resultsRecord) {
			try {
				str.append(operation.calculate());
			} catch (ArithmeticException exception) {
				str.append(exception.getMessage());
			}
		}
		return str.toString();

	}
}