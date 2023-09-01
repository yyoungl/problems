import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static boolean[] chk;
	static int[][] result;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			answer = Integer.MAX_VALUE;
			int N = sc.nextInt();
			chk = new boolean[N];
			result = new int[N+2][2];
			int[][] map = new int[N][2];
			result[0][0] = sc.nextInt();
			result[0][1] = sc.nextInt();
			result[N+1][0] = sc.nextInt();
			result[N+1][1] = sc.nextInt();
			for (int i=0; i<N; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			permutation(map, N, 1);
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	
	public static void permutation(int[][] map, int N, int idx) {
		if (idx==N+1) {
			int dis = 0;
			for (int i=0; i<=N; i++) {
				dis += Math.abs(result[i+1][0]-result[i][0]) +  Math.abs(result[i+1][1]-result[i][1]);
				if (dis > answer) return;
			}
			answer = Math.min(dis, answer);
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (chk[i]) continue;
			result[idx] = map[i];
			chk[i] = true;
			permutation(map, N, idx+1);
			chk[i] = false;
		}
		
	}

}
