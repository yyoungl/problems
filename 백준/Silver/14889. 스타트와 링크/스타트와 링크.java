
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] ability;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		ability = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				ability[i][j] = sc.nextInt();
		}
		boolean[] chk = new boolean[N];
		combination(0, 0, new int[N / 2], chk);
		System.out.println(answer);
	}

	static void combination(int start, int idx, int[] result, boolean[] chk) {
		if (idx == N / 2) {
			int[] team1 = Arrays.copyOf(result, N / 2);
			int[] team2 = new int[N / 2];
			int index = 0;

			for (int i = 0; i < N; i++) {
				if (!chk[i])
					team2[index++] = i;
			}


			int abil1 = 0;
			int abil2 = 0;

			for (int i = 0; i < N / 2; i++) {
				for (int j = i+1; j < N / 2; j++) {
					if (i==j) continue;
					abil1 += (ability[team1[i]][team1[j]] + ability[team1[j]][team1[i]]);
					abil2 += (ability[team2[i]][team2[j]] + ability[team2[j]][team2[i]]);
				}
			}

			answer = Math.min(answer, Math.abs(abil1 - abil2));

			return;
		}

		for (int i = start; i < N; i++) {
			if (!chk[i]) {
				result[idx] = i;
				chk[i] = true;
				combination(i + 1, idx + 1, result, chk);
				chk[i] = false;
			}
		}
	}

}
