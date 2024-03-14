package com.jroslav.converter.converter;

import com.jroslav.converter.normalizer.Normalizer;
import com.jroslav.converter.validator.Validator;

public abstract class AbstractConverter {
	private final Validator validator;
	private final Normalizer normalizer;

	public AbstractConverter(Validator validator, Normalizer normalizer) {
		this.validator = validator;
		this.normalizer = normalizer;
	}

	public String prepareNumber(String number) {
		isValid(number);
		return normalizer.normalize(number);
	}

	private boolean isValid(String number) throws RuntimeException {
		boolean idValid = validator.validate(number);
		if (!idValid) {
			throw new RuntimeException("неправильный ввод числа. Введите еще раз.");
		}
		return idValid;
	}

	public abstract String convert(String value) throws RuntimeException;
}
