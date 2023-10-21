
import java.util.Scanner;

public class Main {
	static int M;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] result = new int[M];
		permutation(result, 0, 0);

	}

	public static void permutation(int[] result, int idx, int start) {
		if (idx == M) {
			for (int i : result) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			result[idx] = i + 1;
			permutation(result, idx + 1, i);
		}
	}
}
