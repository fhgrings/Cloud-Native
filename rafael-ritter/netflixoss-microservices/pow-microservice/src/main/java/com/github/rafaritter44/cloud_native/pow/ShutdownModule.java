package com.github.rafaritter44.cloud_native.pow;

public class ShutdownModule extends netflix.karyon.ShutdownModule{
	
	public ShutdownModule() {
	    super(7007);
	}
	
}