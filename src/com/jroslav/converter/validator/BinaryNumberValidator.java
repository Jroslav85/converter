package com.jroslav.converter.validator;

public class BinaryNumberValidator implements Validator {

	@Override
	public boolean validate(String number) {
		return number.matches("^[01]+$");
	}
}
