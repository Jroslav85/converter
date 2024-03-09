package com.jroslav.app;

import java.util.Scanner;

import com.jroslav.app.converter.BinaryToHexConverter;
import com.jroslav.app.converter.Converter;
import com.jroslav.app.converter.HexToBinaryConverter;
import com.jroslav.app.converter.normalizer.BinaryNormalizer;
import com.jroslav.app.converter.normalizer.HexNormalizer;
import com.jroslav.app.converter.normalizer.Normalizer;
import com.jroslav.app.converter.validator.BinaryNumberValidator;
import com.jroslav.app.converter.validator.HexNumberValidator;
import com.jroslav.app.converter.validator.Validator;

public class Main {
	public static String binaryNumber;
	public static String hexResult;
	public static String hexNumber;
	public static String binaryResult;

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			// ввод двоичного числа.
			// ввывод результата конвертации двоичного числа.
			System.out.println("Введите двоичное число");
			hexResult = convertBinary(console);
			System.out.printf(
					"Двоичное число 0b%s равно шестнадцатеричному числу 0x%s  %n%n",
					binaryNumber, hexResult);

			// ввод шестнадцатеричного числа.
			// ввывод результата конвертации 16-ричного числа.
			System.out.println("Введите шестнадцатеричное число");
			binaryResult = convertHex(console);
			System.out.printf(
					"Шестнадцатеричное число 0x%s равно двоичному числу 0b%s %n",
					hexNumber, binaryResult);
		}
	}

	private static String convertHex(Scanner console) {
		while (true) {
			try {
				hexNumber = console.nextLine();
				Validator validator = new HexNumberValidator();
				Normalizer normalizer = new HexNormalizer();
				Converter converter = new HexToBinaryConverter(validator,
						normalizer);
				return converter.convert(hexNumber);
			} catch (RuntimeException e) {
				System.out.println("введите еще раз.");
			}
		}
	}

	private static String convertBinary(Scanner console) {
		while (true) {
			try {
				binaryNumber = console.nextLine();
				Validator validator = new BinaryNumberValidator();
				Normalizer normalizer = new BinaryNormalizer();
				Converter converter = new BinaryToHexConverter(validator,
						normalizer);
				return converter.convert(binaryNumber);
			} catch (RuntimeException e) {
				System.out.println("введите еще раз.");
			}
		}
	}
}
