import javax.swing.JOptionPane;
public class SystemOfFirstDegreeEquations{
	public static void main(String[] args){
		String strA11, strA12, strB1, strA21, strA22, strB2;
		double a11, a12, b1, a21, a22, b2, x, y, Dx, Dy, D;
		String resultMessage;

		strA11 = JOptionPane.showInputDialog(null, "a11: ", "Input a11", JOptionPane.INFORMATION_MESSAGE);
		a11 = Double.parseDouble(strA11);

		strA12 = JOptionPane.showInputDialog(null, "a12: ", "Input a12", JOptionPane.INFORMATION_MESSAGE);
		a12 = Double.parseDouble(strA12);

		strB1 = JOptionPane.showInputDialog(null, "b1: ", "Input b1", JOptionPane.INFORMATION_MESSAGE);
		b1 = Double.parseDouble(strB1);

		strA21 = JOptionPane.showInputDialog(null, "a21: ", "Input a21", JOptionPane.INFORMATION_MESSAGE);
		a21 = Double.parseDouble(strA21);

		strA22 = JOptionPane.showInputDialog(null, "a22: ", "Input a22", JOptionPane.INFORMATION_MESSAGE);
		a22 = Double.parseDouble(strA22);

		strB2 = JOptionPane.showInputDialog(null, "b2: ", "Input b2", JOptionPane.INFORMATION_MESSAGE);
		b2 = Double.parseDouble(strB2);

		D = a11 * a22 - a12 * a21;
		if(D == 0){
			resultMessage = "Infinite solutions!";
		}else{
			Dx = b1*a22 - b2*a12;
			Dy = a11*b2 - a21*b1;

			x = Dx/D; y = Dy/D;
			resultMessage = "Solution: (" + Double.toString(x) + "," + Double.toString(y) + ")";
		}
		
		JOptionPane.showMessageDialog(null, resultMessage, "Solution", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
