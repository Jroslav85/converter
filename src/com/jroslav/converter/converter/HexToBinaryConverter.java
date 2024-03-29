package com.jroslav.converter.converter;

import static java.util.Map.entry;

import java.util.Map;

import com.jroslav.converter.converter.validator.HexNumberValidator;
import com.jroslav.converter.converter.validator.Validator;

public class HexToBinaryConverter implements Converter {
	private Validator validator = HexNumberValidator.getValidator();

	private static final Map<String, String> MASK_HEX = Map.ofEntries(
			entry("0", "0000"), entry("1", "0001"), entry("2", "0010"),
			entry("3", "0011"), entry("4", "0100"), entry("5", "0101"),
			entry("6", "0110"), entry("7", "0111"), entry("8", "1000"),
			entry("9", "1001"), entry("a", "1010"), entry("b", "1011"),
			entry("c", "1100"), entry("d", "1101"), entry("e", "1110"),
			entry("f", "1111"));

	@Override
	public String convert(String hexNumber) throws RuntimeException {
		getNumberResult(hexNumber);

		StringBuilder binaryString = new StringBuilder();
		String[] hexArray = hexNumber.toLowerCase().split("");
		for (String str : hexArray) {
			binaryString.append(MASK_HEX.get(str));
		}
		return binaryString.toString();
	}

	private void getNumberResult(String hexNumber) {
		boolean idValid = validator.validate(hexNumber);
		if (!idValid) {
			throw new RuntimeException();
		}
	}
}
