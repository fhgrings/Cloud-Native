package com.github.vinifkroth.cloudnative.tema3.exception;

public class InvalidOperationException extends Exception {

	private static final long serialVersionUID = -3517170452748690517L;

	public InvalidOperationException(String erro) {
		super(erro);
	}

	public InvalidOperationException(Exception e) {
		super(e.getMessage());
	}

	public InvalidOperationException(String erro, Exception e) {
		super(erro, e);
	}
}