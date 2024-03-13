package com.jroslav.app;
// FIXME: 13.03.2024 app - неудачное название для апликухи:) лучше уже converter или numberconvertor

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
	// FIXME: 13.03.2024 статик-поля здесь не нужен. И конкретно в таком виде - плохая практика
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
				// FIXME: 13.03.2024 Нелогично. Если метод convert() - он должен на вход принимать уже число,
				//  а не строго определенный источник ввода (сканер)
				hexNumber = console.nextLine();
				Validator validator = new HexNumberValidator();
				Normalizer normalizer = new HexNormalizer();
				Converter converter = new HexToBinaryConverter(validator,
						// FIXME: 13.03.2024 вполне помещалось на предыдущей строке
						normalizer);
				return converter.convert(hexNumber);
			} catch (RuntimeException e) {
				// FIXME: 13.03.2024 Если пытаешься в юзабилити - где аварийный выход?)
				//  Например, не нужно мне больше 16ричное число конвертить
				System.out.println("введите еще раз.");
			}
		}
	}

	private static String convertBinary(Scanner console) {
		// FIXME: 13.03.2024 замечания аналогичны тем, что выше
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
