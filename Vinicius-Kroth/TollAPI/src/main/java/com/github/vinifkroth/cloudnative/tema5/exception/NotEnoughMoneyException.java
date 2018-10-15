package com.github.vinifkroth.cloudnative.tema5.exception;

public class NotEnoughMoneyException extends Exception {

	private static final long serialVersionUID = -3517170452748690517L;

	public NotEnoughMoneyException(String erro) {
		super(erro);
	}

	public NotEnoughMoneyException(Exception e) {
		super(e.getMessage());
	}

	public NotEnoughMoneyException(String erro, Exception e) {
		super(erro, e);
	}
}