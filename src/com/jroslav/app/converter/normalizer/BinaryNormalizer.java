package com.jroslav.app.converter.normalizer;

public class BinaryNormalizer implements Normalizer {

	@Override
	public String normalize(String number) {
		int lengthDivisibleByFour = number.length() % 4;
		return lengthDivisibleByFour != 0
				? "0".repeat(4 - lengthDivisibleByFour) + number
				: number;
	}
}
