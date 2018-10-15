package com.github.fhgrings.rxNetty.App;

import com.github.fhgrings.rxNetty.Operations.Calculator;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import rx.Observable;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

    private final String calculatorUri;
    private final Calculator calculator;

    public RxNettyHandler(String calculatorUri, Calculator calculator) {
        this.calculatorUri = calculatorUri;
        this.calculator = calculator;
    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
        if (request.getUri().startsWith(calculatorUri)) {
            response.setStatus(HttpResponseStatus.OK);
            calculator.calculate(1, 2, "sum");
            return response.writeStringAndFlush(calculator.getMapHistory());
        } else if (request.getUri().startsWith("/calculate")){
            int prefixLength = "/calculate/".length();

            try{
                String function = request.getPath().substring(prefixLength);
                String[] parts = function.split("&");
                String operator = parts[0];
                String firstValue = parts[1];
                String secondValue = parts[2];

                return response.writeStringAndFlush(String.valueOf(
                        calculator.calculate(
                                Double.parseDouble(firstValue),
                                Double.parseDouble(secondValue),
                                operator)));
            } catch (Exception exception) {
                response.setStatus(HttpResponseStatus.BAD_REQUEST);
                return response.writeStringAndFlush("Error: Please provide all requirements");
            }

        } else {
            response.setStatus(HttpResponseStatus.BAD_REQUEST);
            return response.close();
        }
    }
}