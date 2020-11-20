import java.text.DecimalFormat;

public class TestMathOperations {

	public static void main(String[] args) {
		MathOperations calculator = new MathOperations();
		
		System.out.println(calculator.inverse(3));
		System.out.println(calculator.inverse(7));
		
		calculator.printInverse(3);
		calculator.printInverse(7);
		
		calculator.printInverse(3, "0.0");
		calculator.printInverse(7, "0.00000");
		
		DecimalFormat one_place = new DecimalFormat("0.0");
		calculator.printInverse(3, one_place);
		DecimalFormat five_places = new DecimalFormat("0.00000");
		calculator.printInverse(7, five_places);
	}
}