
import java.util.Scanner;

public class Main {

	static int M;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		int[] result = new int[M];
		permutation(result, 0);
		System.out.println(sb.toString());
	}

	public static void permutation(int[] result, int idx) {
		if (idx == M) {
			for (int i : result) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			result[idx] = i + 1;
			permutation(result, idx + 1);
		}
	}

}
