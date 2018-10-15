package com.github.vinifkroth.cloudnative.tema2.exception;

public class IdNotFoundException extends Exception {

	private static final long serialVersionUID = -3517170452748690517L;

	public IdNotFoundException(String erro) {
		super(erro);
	}

	public IdNotFoundException(Exception e) {
		super(e.getMessage());
	}

	public IdNotFoundException(String erro, Exception e) {
		super(erro, e);
	}
}