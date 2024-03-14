package com.jroslav.converter;

import java.util.Scanner;

import com.jroslav.converter.converter.AbstractConverter;
import com.jroslav.converter.converter.BinaryToHexConverter;
import com.jroslav.converter.converter.HexToBinaryConverter;
import com.jroslav.converter.normalizer.BinaryNormalizer;
import com.jroslav.converter.normalizer.HexNormalizer;
import com.jroslav.converter.normalizer.Normalizer;
import com.jroslav.converter.validator.BinaryNumberValidator;
import com.jroslav.converter.validator.HexNumberValidator;
import com.jroslav.converter.validator.Validator;

public class Main {

	public static void main(String[] args) {

		try (Scanner console = new Scanner(System.in)) {
			// ввод двоичного числа.
			// ввывод результата конвертации двоичного числа.
			System.out.println("Введите двоичное число");
			String binaryNumber;
			String hexResult = null;
			while (hexResult == null) {
				try {
					binaryNumber = console.nextLine();
					hexResult = convertBinary(binaryNumber);
					System.out.printf(
							"Двоичное число 0b%s равно шестнадцатеричному числу 0x%s  %n%n",
							binaryNumber, hexResult
					);
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}

			// ввод шестнадцатеричного числа.
			// ввывод результата конвертации 16-ричного числа.
			System.out.println("Введите шестнадцатеричное число");
			String hexNumber;
			String binaryResult = null;
			while (binaryResult == null) {
				try {
					hexNumber = console.nextLine();
					binaryResult = convertHex(hexNumber);
					System.out.printf(
							"Шестнадцатеричное число 0x%s равно двоичному числу 0b%s %n", hexNumber,
							binaryResult
					);
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	private static String convertBinary(String binaryNumber) throws RuntimeException {
		Validator validator = new BinaryNumberValidator();
		Normalizer normalizer = new BinaryNormalizer();
		AbstractConverter converter = new BinaryToHexConverter(validator, normalizer);
		return converter.convert(binaryNumber);
	}

	private static String convertHex(String hexNumber) {
		Validator validator = new HexNumberValidator();
		Normalizer normalizer = new HexNormalizer();
		AbstractConverter converter = new HexToBinaryConverter(validator, normalizer);
		return converter.convert(hexNumber);
	}
}
