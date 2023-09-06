
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] nums = str.toCharArray();
		
		for (int i=0; i<nums.length; i++) {
			for (int j=i; j<nums.length; j++) {
				if (nums[i] < nums[j]) {
					char temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
		System.out.println(String.copyValueOf(nums));
	}

}
