package com.github.rafaritter44.cloud_native.pow;

import com.netflix.config.ConfigurationManager;

public class ServerRunner {
	public static void main(String[] args) {
		System.setProperty("java.awt.headless","true");
		System.setProperty("archaius.deployment.environment","dev");
		ConfigurationManager.getConfigInstance().setProperty("netflix.platform.admin.resources.port", 8092);
		netflix.karyon.KaryonRunner.main(new String[]{KaryonJerseyServerApp.class.getCanonicalName()});
	}
}
