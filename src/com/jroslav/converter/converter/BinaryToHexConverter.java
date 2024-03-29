package com.jroslav.converter.converter;

import static java.util.Map.entry;

import java.util.Map;

import com.jroslav.converter.converter.normalizer.BinaryNormalizer;
import com.jroslav.converter.converter.normalizer.Normalizer;
import com.jroslav.converter.converter.validator.BinaryNumberValidator;
import com.jroslav.converter.converter.validator.Validator;

public class BinaryToHexConverter implements Converter {
	private Normalizer normalizer = BinaryNormalizer.getNormalizer();
	private Validator validator = BinaryNumberValidator.getValidator();

	private static final Map<String, String> MASK_BIN = Map.ofEntries(
			entry("0000", "0"), entry("0001", "1"), entry("0010", "2"),
			entry("0011", "3"), entry("0100", "4"), entry("0101", "5"),
			entry("0110", "6"), entry("0111", "7"), entry("1000", "8"),
			entry("1001", "9"), entry("1010", "a"), entry("1011", "b"),
			entry("1100", "c"), entry("1101", "d"), entry("1110", "e"),
			entry("1111", "f"));

	@Override
	public String convert(String binaryNumber) throws RuntimeException {

		binaryNumber = getNumberResult(binaryNumber);
		StringBuilder hexString = new StringBuilder();
		String[] binaryArray = binaryNumber.split("(?<=\\G.{" + 4 + "})");

		for (int i = 0; i < binaryArray.length; i++) {
			
			String str = binaryArray[i];
			hexString.append(MASK_BIN.get(str));
		}
		return hexString.toString();
	}

	private String getNumberResult(String binaryNumber) {
		boolean idValid = validator.validate(binaryNumber);
		if (!idValid) {
			throw new RuntimeException();
		}

		binaryNumber = normalizer.normalize(binaryNumber);
		return binaryNumber;
	}
}
