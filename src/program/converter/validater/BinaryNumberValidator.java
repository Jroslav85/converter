package program.converter.validater;

public class BinaryNumberValidator implements Validator {

	public BinaryNumberValidator() {

	}

	@Override
	public boolean validateInputNumber(String number) {
		if (number.matches("^[01]+$")) {
			return true;
		}
		return false;
	}
}
