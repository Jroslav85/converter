package program.converter.normalizer;

public class BinaryNormalizer implements Normalizer {

	@Override
	public String getCorrectNumber(String number){
		int lengthDivisibleByFour = number.length() % 4;
	    return  lengthDivisibleByFour != 0 ? "0".repeat(4 - lengthDivisibleByFour) + number : number;
	}
}
