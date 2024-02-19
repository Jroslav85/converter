package program.converter;

import static java.util.Map.entry;

import java.util.Map;

import program.converter.normalizer.BinaryNormalizer;
import program.converter.validater.BinaryNumberValidator;

public class BinaryToHexConverter implements Converter {

	private static final Map<String, String> MASK_BIN = Map.ofEntries(entry("0000", "0"), entry("0001", "1"),
			entry("0010", "2"), entry("0011", "3"), entry("0100", "4"), entry("0101", "5"), entry("0110", "6"),
			entry("0111", "7"), entry("1000", "8"), entry("1001", "9"), entry("1010", "a"), entry("1011", "b"),
			entry("1100", "c"), entry("1101", "d"), entry("1110", "e"), entry("1111", "f"));

	@Override
	public String convert(String binaryNumber) throws RuntimeException {

		BinaryNumberValidator validator = new BinaryNumberValidator();
		boolean isValidate = validator.validateInputNumber(binaryNumber);
		if (!isValidate) {
			throw new RuntimeException();
		}

		BinaryNormalizer normalizer = new BinaryNormalizer();
		binaryNumber = normalizer.getCorrectNumber(binaryNumber);

		StringBuilder hexString = new StringBuilder();
		String[] binaryArray = binaryNumber.split("(?<=\\G.{" + 4 + "})");

		int i = binaryArray[0].equals("0000") ? 1 : 0;// убирает лишний ноль вначале числа
		for (; i < binaryArray.length; i++) {
			String str = binaryArray[i];
			hexString.append(MASK_BIN.get(str));
		}

		String resultHex = hexString.toString();
		return resultHex;
	}

}
