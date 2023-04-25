import javax.swing.JOptionPane;
public class ShowTwoNumbers{
	public static void main(String[] args){
		String strNum1, strNum2;
		String strNotification = "You've just entered: ";
		double result;

		strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum1 + " and ";
		
		strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
		strNotification += strNum2;
		
		result = Double.parseDouble(strNum1) + Double.parseDouble(strNum2);

		JOptionPane.showMessageDialog(null, result, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
