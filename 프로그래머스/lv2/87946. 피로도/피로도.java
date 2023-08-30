import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static ArrayList<int[]> permu = new ArrayList<>();
	static int N;
	static int[] sequence;

	public static int solution(int k, int[][] dungeons) {
		int answer = -1;
		N = dungeons.length;
		boolean[] check = new boolean[N];
		sequence = new int[N];
		permutation(0, check, sequence);
		for (int[] p : permu) {
			int tired = k;
			int cnt = 0;
			for (int i : p) {
				if (tired>=dungeons[i][0] && tired>=dungeons[i][1]) {
					cnt++;
					tired -= dungeons[i][1];
				}
			}
			answer = Math.max(cnt, answer);
		}
		return answer;
	}

	public static void permutation(int r, boolean[] check, int[] sequence) {
		if (r == N) {
			int[] result = Arrays.copyOf(sequence, N);
			permu.add(result);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				sequence[r] = i;
				permutation(r + 1, check, sequence);
				check[i] = false;
			}
		}
	}

}