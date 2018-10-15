package com.github.vinifkroth.cloudnative.tema5.exception;

public class InvalidVehicleException extends Exception {

	private static final long serialVersionUID = -3517170452748690517L;

	public InvalidVehicleException(String erro) {
		super(erro);
	}

	public InvalidVehicleException(Exception e) {
		super(e.getMessage());
	}

	public InvalidVehicleException(String erro, Exception e) {
		super(erro, e);
	}
}