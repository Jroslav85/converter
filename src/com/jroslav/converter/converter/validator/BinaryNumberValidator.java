package com.jroslav.converter.converter.validator;

public class BinaryNumberValidator implements Validator {
	private static Validator validator = null;
	
	private BinaryNumberValidator() {
	}
	
	public static Validator getValidator() {
		if(validator == null) {
			validator = new BinaryNumberValidator();
		}
		return validator;
	}

	@Override
	public boolean validate(String number) {
		return number.matches("^[01]+$");
	}
}
