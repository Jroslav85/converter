package com.jroslav.converter.normalizer;

public class HexNormalizer implements Normalizer {

	@Override
	public String normalize(String value) {
		return value.toLowerCase();
	}
}
