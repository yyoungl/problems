import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		for (int i=0; i<N; i++) {
			String[] nums = sc.next().split("");
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[2]);
			
			System.out.println((a+b));
		}
	}

}
