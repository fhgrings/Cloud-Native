package com.github.rafaritter44.cloud_native.rxnetty.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang.StringUtils;

import com.github.rafaritter44.cloud_native.rxnetty.calculator.Calculator;
import com.github.rafaritter44.cloud_native.rxnetty.calculator.Operation;
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
		} else if (uri.startsWith("/History")) {
			List<Object> history = new ArrayList<>();
			for (Operation operation : calculator.getHistory()) {
				try {
					history.add(operation.calculate());
				} catch (ArithmeticException exception) {
					history.add(exception.getMessage());
				}
			}
			return response.writeStringAndFlush(new Gson().toJson(history));
		} else if (Stream.of("/Addition/", "/Subtraction/", "/Multiplication/", "/Division/", "/Exponentiation/")
				.anyMatch(uri::startsWith)) {
			int prefixLength = uri.indexOf("/", 1);
			String[] operands = uri.substring(prefixLength + 1).split("/");
			if (operands.length == 2 && Stream.of(operands).allMatch(StringUtils::isNumeric)) {
				String operationName = uri.substring(1, prefixLength);
				try {
					return response.writeStringAndFlush("{\"Result\":" + calculator.calculate(operationName,
							Double.parseDouble(operands[0]), Double.parseDouble(operands[1])) + "}");
				} catch (ArithmeticException | ReflectiveOperationException exception) {
					return response.writeStringAndFlush("{\"Error\":\"" + exception.getMessage() + "\"}");
				}
			} else {
				response.setStatus(HttpResponseStatus.BAD_REQUEST);
				return response.writeStringAndFlush(
						"{\"Error\":\"Please provide operands. The URI should be /{operation}/{operand1}/{operand2}\"}");
			}
		} else {
			response.setStatus(HttpResponseStatus.NOT_FOUND);
			return response.close();
		}
	}
}