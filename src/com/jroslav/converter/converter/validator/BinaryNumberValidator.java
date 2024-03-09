package com.jroslav.converter.converter.validator;

public class BinaryNumberValidator implements Validator {

	@Override
	public boolean validate(String number) {
		return number.matches("^[01]+$");
	}
}
