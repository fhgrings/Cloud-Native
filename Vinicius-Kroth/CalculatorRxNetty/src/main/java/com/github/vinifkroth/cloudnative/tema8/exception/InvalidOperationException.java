package com.github.vinifkroth.cloudnative.tema8.exception;

public class InvalidOperationException extends Exception {

	private static final long serialVersionUID = -3517170452748690517L;

	public InvalidOperationException(String erro) {
		super(erro);
	}
}