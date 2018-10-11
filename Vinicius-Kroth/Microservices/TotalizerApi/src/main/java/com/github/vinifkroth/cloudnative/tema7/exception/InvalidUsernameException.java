package com.github.vinifkroth.cloudnative.tema7.exception;

public class InvalidUsernameException extends Exception {

	private static final long serialVersionUID = -3517170452748690517L;

	public InvalidUsernameException(String erro) {
		super(erro);
	}

	public InvalidUsernameException(Exception e) {
		super(e.getMessage());
	}

	public InvalidUsernameException(String erro, Exception e) {
		super(erro, e);
	}
}