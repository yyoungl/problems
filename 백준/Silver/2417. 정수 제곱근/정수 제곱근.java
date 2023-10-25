
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long left = 0;
		long right = N;
		long answer = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			if (Math.pow(mid, 2) >= N) {
				answer = mid;
				right = mid-1;
			} else left = mid+1;
		}
		String temp = "";
		temp += answer;
		System.out.println(temp);
	
	}

}
