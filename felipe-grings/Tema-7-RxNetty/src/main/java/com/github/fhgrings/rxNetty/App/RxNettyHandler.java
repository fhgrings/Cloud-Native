package com.github.fhgrings.rxNetty.App;

import com.github.fhgrings.rxNetty.operations.Calculator;
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

            return response.writeStringAndFlush(String.valueOf(calculator.getMapHistory()));

        } else if (request.getUri().startsWith("/calculate")){
            int prefixLength = "/calculate/".length();

            try{
                String service = request.getPath().substring(prefixLength);

                return response.writeStringAndFlush(String.valueOf(
                        calculator.calculate(
                                firstValueExtractor(service),
                                secondValueExtractor(service),
                                operatorExtractor(service))));

            } catch (Exception exception) {
                response.setStatus(HttpResponseStatus.BAD_REQUEST);
                return response.writeStringAndFlush(exception.getMessage());
            }

        } else {
            response.setStatus(HttpResponseStatus.NOT_FOUND);
            return response.close();
        }
    }


    public String operatorExtractor(String service) {
            String[] parts = service.split("&");
            return parts[0];
    }

    public double firstValueExtractor(String service) {
        String[] parts = service.split("&");
        return Double.parseDouble(parts[1]);
    }

    public double secondValueExtractor(String service) {
        String[] parts = service.split("&");
        return Double.parseDouble(parts[2]);
    }
}