package com.jroslav.converter.converter;

import com.jroslav.converter.converter.normalizer.Normalizer;
import com.jroslav.converter.converter.validator.Validator;

public abstract class AbstractConverter implements
Converter{
	private Validator validator;
	private Normalizer normalizer;
	
	public AbstractConverter(Validator validator, Normalizer normalizer) {
		this.validator = validator;
		this.normalizer = normalizer;
	}
	
	protected String getNumberResult(String number) {
		boolean idValid = validator.validate(number);
		if (!idValid) {
			throw new RuntimeException();
		}
		number = normalizer.normalize(number);
		return number;
	}
}
