import javax.swing.JOptionPane;
import java.lang.Math;
class LinearEquationSecondDegree{
	public static void main(String[] args){
		String strA, strB, strC;
		String resultMessage = "";
		double a, b, c, delta, x1, x2;

		strA = JOptionPane.showInputDialog(null, "Input the first number: ", "Input a", JOptionPane.INFORMATION_MESSAGE);
		a = Double.parseDouble(strA);

		strB = JOptionPane.showInputDialog(null, "Input the second number: ", "Input b", JOptionPane.INFORMATION_MESSAGE);
		b = Double.parseDouble(strB);
		
		strC = JOptionPane.showInputDialog(null, "Input the last number: ", "Input c", JOptionPane.INFORMATION_MESSAGE);
		c = Double.parseDouble(strC);

		if(a == b && b == 0 && c == 0){
			resultMessage += "Infinite solutions found!";
		}else{
			delta = b*b - 4*a*c;	
			if(delta < 0){
				resultMessage += "No solution found!";
			}else if(delta == 0){
				x1 = -b/(2*a);
				resultMessage += Double.toString(x1);
			}else{
				x1 = (-b-Math.sqrt(delta))/(2*a);
				x2 = (-b+Math.sqrt(delta))/(2*a);
				resultMessage += "Two solutions: x1 = " + Double.toString(x1) + " and x2 = " + Double.toString(x2);
			}
		}
		JOptionPane.showMessageDialog(null, resultMessage, "Show results", JOptionPane.INFORMATION_MESSAGE);
	}
}
