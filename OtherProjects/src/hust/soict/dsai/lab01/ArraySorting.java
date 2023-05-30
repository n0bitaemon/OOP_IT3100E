package hust.soict.dsai.lab01;

public class ArraySorting{
	public static void main(String[] args){
		int sum = 0;
		int nums[] = {1789, 2035, 1899, 1456, 2013};

		//Selection sort
		for(int i = 0; i < nums.length - 1; i++){
			int min_index = i;
			for(int j = i+1; j < nums.length; j++){
				if(nums[min_index] > nums[j]){
					min_index = j;
				}
			}
			//Swap
			int temp = nums[i];
			nums[i] = nums[min_index];
			nums[min_index] = temp;
		}

		//Print new array
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			System.out.printf("%d, ", nums[i]);
		}
		System.out.printf("\nAverage value: %.3f\n", ((float)sum / (float)nums.length));
	}
}
