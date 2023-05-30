package hust.soict.dsai.lab01;

public class AddingMatrices{
	public static void main(String[] args){
		int[][] matrix_a = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[][] matrix_b = {{5,2,1}, {4,2,2}, {6,12,5}};
		int matrix_s[][] = new int[3][3];

		for(int i = 0; i < matrix_a.length; i++){
			for(int j = 0; j < matrix_a[0].length; j++){
				matrix_s[i][j] = matrix_a[i][j] + matrix_b[i][j];
			}
		}

		//Print sum matrix
		for(int i = 0; i < matrix_s.length; i++){
			for(int j = 0; j < matrix_s[i].length; j++){
				System.out.printf("%d ", matrix_s[i][j]);
			}
			System.out.println();
		}
	}
}
