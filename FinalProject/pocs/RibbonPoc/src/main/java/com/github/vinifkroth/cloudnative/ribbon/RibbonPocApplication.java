package com.github.vinifkroth.cloudnative.ribbon;

import java.util.ArrayList;

import com.google.common.collect.Lists;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;

import rx.Observable;

public class RibbonPocApplication {

	public static void main(String[] args) {

		ArrayList<Server> servers = Lists.newArrayList(new Server("www.google.com", 80),
				new Server("www.linkedin.com", 80), new Server("www.yahoo.com", 80));
		BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(servers);
		
		for (int i = 0; i < 10; i++)
			System.out.println(call(loadBalancer));
	}

	private static String call(BaseLoadBalancer loadBalancer) {
		
		return LoadBalancerCommand
				.<String>builder()
				.withLoadBalancer(loadBalancer)
				.build()
				.submit(new ServerOperation<String>() {
					@Override
					public rx.Observable<String> call(Server server) {
						try {
							return rx.Observable.just(server.getHost());
						} catch (Exception e) {
							return Observable.error(e);
						}
					}
				}).toBlocking().first();
	}

}
