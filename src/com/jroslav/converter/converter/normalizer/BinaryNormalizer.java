package com.jroslav.converter.converter.normalizer;

public class BinaryNormalizer implements Normalizer {
	private static Normalizer normalizer = null;

	private BinaryNormalizer() {

	}

	public static Normalizer getNormalizer() {
		if (normalizer == null) {
			normalizer = new BinaryNormalizer();
		}
		return normalizer;
	}
	
	@Override
	public String normalize(String number) {
		int lengthDivisibleByFour = number.length() % 4;
		return lengthDivisibleByFour != 0
				? "0".repeat(4 - lengthDivisibleByFour) + number
				: number;
	}
}
