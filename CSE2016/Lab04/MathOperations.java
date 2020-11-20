import java.text.*;

public class MathOperations {
  public double inverse(int n) {
    return 1.0 / n;
  }
  public void printInverse(int n) {
    DecimalFormat formatter = new DecimalFormat("0.000");
    double i = 1.0 / n;
    System.out.println(formatter.format(i));
  }
  public void printInverse(int n, String pattern) {
    DecimalFormat formatter = new DecimalFormat(pattern);
    double i = 1.0 / n;
    System.out.println(formatter.format(i));
  }
  public void printInverse(int n, DecimalFormat formatter) {
    double i = 1.0 / n;
    System.out.println(formatter.format(i));
  }
}