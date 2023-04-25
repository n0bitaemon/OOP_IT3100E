import javax.swing.JOptionPane;
class LinearEquationFirstDegree{
	public static void main(String[] args){
		String strA, strB;
		double a, b, x;
		strA = JOptionPane.showInputDialog(null, "Input a in the equation: ", "a = ", JOptionPane.INFORMATION_MESSAGE);
		a = Double.parseDouble(strA);
		if(a == 0){
			JOptionPane.showMessageDialog(null, "The first number cannot be zero!", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		strB = JOptionPane.showInputDialog(null, "Input b in the equation: ", "b = ", JOptionPane.INFORMATION_MESSAGE);	
		b = Double.parseDouble(strB);

		x = -b/a;
		JOptionPane.showMessageDialog(null, x, "Your results: ", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
