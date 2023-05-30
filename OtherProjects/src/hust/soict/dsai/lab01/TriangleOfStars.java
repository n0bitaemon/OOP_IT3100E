package hust.soict.dsai.lab01;

import java.util.Scanner;
public class TriangleOfStars{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n*2; j++){
				if(j < n-i-1){
					System.out.print(" ");
				}else if(j >= n-i){
					for(int k = 0; k < 2*i+1; k++){
						System.out.print("*");
					}
					break;
				}
			}
			System.out.println();
		}
	}
}
