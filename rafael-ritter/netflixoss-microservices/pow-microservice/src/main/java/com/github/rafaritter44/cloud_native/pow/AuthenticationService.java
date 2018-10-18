package com.github.rafaritter44.cloud_native.pow;

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import rx.Observable;

public interface AuthenticationService {
    Observable<Boolean> authenticate(HttpServerRequest<ByteBuf> request);
}