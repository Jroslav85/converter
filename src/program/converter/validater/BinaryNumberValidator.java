package program.converter.validater;

public class BinaryNumberValidator implements Validator {

	@Override
	public boolean validateInputNumber(String number) {
		if (number.matches("^[01]+$")) {
			return true;
		}
		return false;
	}
}
