package program.converter.validater;

public class HexNumberValidator implements Validator {

	@Override
	public boolean validateInputNumber(String number) {
		if (number.matches("^[1-9a-f][\\da-f]*$")) {
			return true;
		}
		return false;
	}

}
