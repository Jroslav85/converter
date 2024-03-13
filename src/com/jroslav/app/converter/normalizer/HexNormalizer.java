package com.jroslav.app.converter.normalizer;

public class HexNormalizer implements Normalizer {

	@Override
	public String normalize(String value) {
// FIXME: 13.03.2024 Просто для информации: даже если бы ты тут просто написал `return value;` - все еще было бы норм:)
		return value.toLowerCase();
	}
}
