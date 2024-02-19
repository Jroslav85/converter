package program;

import java.util.Scanner;

import program.converter.BinaryToHexConverter;
import program.converter.HexToBinaryConverter;

public class Main {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {

			// ввод двоичного числа.
			// ввывод результата конвертации двоичного числа.
			System.out.println("Введите двоичное число");
			String binaryNumber = null;
			String hexResult = null;

			while (true) {
				try {
					binaryNumber = console.nextLine();
					hexResult = new BinaryToHexConverter().convert(binaryNumber);
					break;
				} catch (RuntimeException e) {
					System.out.println("введите еще раз");
				}
			}
			System.out.printf("Двоичное число 0b%s равно шестнадцатеричному числу 0x%s  %n%n", binaryNumber, hexResult);
			
			
			// ввод шестнадцатеричного числа.
			// ввывод результата конвертации 16-ричного числа.
			System.out.println("Введите шестнадцатеричное число");
			String hexNumber = null;
			String binaryResult = null;
			
			while (true) {
				try {
					hexNumber = console.nextLine();
					binaryResult = new HexToBinaryConverter().convert(hexNumber);
					break;
				} catch (RuntimeException e) {
					System.out.println("введите еще раз");
				}
			}
			System.out.printf("Шестнадцатеричное число 0x%s равно двоичному числу 0b%s ", hexNumber, binaryResult);
		}
	}

	

}
