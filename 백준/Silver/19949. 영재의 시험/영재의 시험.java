
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] answers = new int[10];
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++)
			answers[i] = sc.nextInt();

		int[] pick = new int[10];
		
		combination(0, pick);
		System.out.println(answer);
	}

	static void combination(int idx, int[] pick) {
		if (idx == 10) {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				if (pick[i] == answers[i]) {
					sum++;
				}
			}

			if (sum >= 5)
				answer++;
			return;
		}

		for (int i = 1; i <= 5; i++) {
			if (idx >= 2 && pick[idx - 2] == pick[idx - 1] && pick[idx - 1] == i) continue;
			pick[idx] = i;
			combination(idx+1, pick);
		}
	}

}
