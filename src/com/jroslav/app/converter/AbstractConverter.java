package com.jroslav.app.converter;

import com.jroslav.app.converter.normalizer.Normalizer;
import com.jroslav.app.converter.validator.Validator;

public abstract class AbstractConverter implements
//		fixme: Лишний перенос на след строку, пропущен пробел
Converter{
	// FIXME: 13.03.2024 Обычно поля логики, инициализируемые конструктором, помечают как final
	private Validator validator;
	private Normalizer normalizer;
	
	public AbstractConverter(Validator validator, Normalizer normalizer) {
		this.validator = validator;
		this.normalizer = normalizer;
	}

	// FIXME: 13.03.2024 неудачно название метода. Мб что-то вроде prepareNumber()?
	protected String getNumberResult(String number) {
		boolean idValid = validator.validate(number);
		if (!idValid) {
			// FIXME: 13.03.2024 Оставлять эксепшны без описания - плохая практика. Сообщение также ценно, как и стектрейс
			throw new RuntimeException();
		}
		// FIXME: 13.03.2024 `return normalizer.normalize(number);` выглядело бы лучше
		number = normalizer.normalize(number);
		return number;
	}
}
