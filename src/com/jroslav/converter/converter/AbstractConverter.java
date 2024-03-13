package com.jroslav.converter.converter;

import com.jroslav.converter.normalizer.Normalizer;
import com.jroslav.converter.validator.Validator;

public abstract class AbstractConverter {
	private Validator validator;
	private Normalizer normalizer;

	public AbstractConverter(Validator validator, Normalizer normalizer) {
		this.validator = validator;
		this.normalizer = normalizer;
	}

	protected String prepareNumber(String number) {
		boolean idValid = validator.validate(number);
		if (!idValid) {
			throw new RuntimeException();
		}
		return normalizer.normalize(number);
	}

	public abstract String convert(String value) throws RuntimeException;
}
