package com.jroslav.converter.converter.validator;

public class HexNumberValidator implements Validator {
	private static Validator validator = null;

	private HexNumberValidator() {
	}

	public static Validator getValidator() {
		if (validator == null) {
			validator = new HexNumberValidator();
		}
		return validator;
	}

	@Override
	public boolean validate(String number) {
		return number.matches("^[0-9a-fA-F]+$");
	}
}
