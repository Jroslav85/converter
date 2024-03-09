package com.jroslav.converter.converter.validator;

public class HexNumberValidator implements Validator {

	@Override
	public boolean validate(String number) {
		return number.matches("^[0-9a-fA-F]+$");
	}
}
