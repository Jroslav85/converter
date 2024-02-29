package com.jroslav.converter;

import java.util.Scanner;

import com.jroslav.converter.converter.BinaryToHexConverter;
import com.jroslav.converter.converter.HexToBinaryConverter;

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
			convertBinary(console);
			System.out.printf(
					"Двоичное число 0b%s равно шестнадцатеричному числу 0x%s  %n%n",
					binaryNumber, hexResult);

			// ввод шестнадцатеричного числа.
			// ввывод результата конвертации 16-ричного числа.
			System.out.println("Введите шестнадцатеричное число");
			convertHex(console);
			System.out.printf(
					"Шестнадцатеричное число 0x%s равно двоичному числу 0b%s %n",
					hexNumber, binaryResult);
		}
	}

	private static void convertHex(Scanner console) {
		while (true) {
			try {
				hexNumber = console.nextLine();
				binaryResult = new HexToBinaryConverter().convert(hexNumber);
				break;
			} catch (RuntimeException e) {
				System.out.println("введите еще раз.");
			}
		}
	}

	private static void convertBinary(Scanner console) {
		while (true) {
			try {
				binaryNumber = console.nextLine();
				hexResult = new BinaryToHexConverter().convert(binaryNumber);
				break;
			} catch (RuntimeException e) {
				System.out.println("введите еще раз.");
			}
		}
	}
}
