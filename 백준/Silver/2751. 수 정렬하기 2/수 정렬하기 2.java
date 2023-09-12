import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		List<Integer> nums = new ArrayList<>();
		for (int i=0; i<N; i++)
			nums.add(sc.nextInt());
		
		Collections.sort(nums);
		
		for (int i: nums) sb.append(i+"\n");
		
		System.out.println(sb.toString());
		
	}

}
