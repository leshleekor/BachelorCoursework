// CSE2016 - Lab#3-1

import javax.swing.*;
import java.text.*;

public class FtoC {
	public static void main(String[] args) {
		String message = "화씨 온도를 입력해주세요.";
		String input = JOptionPane.showInputDialog(message);
		double f = Double.parseDouble(input);
		double c = (f - 32) * 5.0 / 9.0;
		DecimalFormat formatter = new DecimalFormat("0.00");
		String output = "화씨 " + f + "도는 ";
		output += "섭씨로 " + formatter.format(c) + "도 입니다.";
		JOptionPane.showMessageDialog(null, output);
	}
}