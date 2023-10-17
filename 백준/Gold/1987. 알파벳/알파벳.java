
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int R;
	static int C;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int answer;
	static char[][] map;
	static boolean[] alpha;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		boolean[] chk = new boolean[26];
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		answer = 0;

		chk[map[0][0]-'A'] = true;
		dfs(0, 0, chk, 1);
		System.out.println(answer);

	}

	static void dfs(int r, int c, boolean[] chk, int cnt) {
		answer = Math.max(cnt,  answer);
		
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isValid(nr, nc) && !chk[map[nr][nc] - 'A']) {
				chk[map[nr][nc] - 'A'] = true;
				dfs(nr, nc, chk, cnt+1);
				chk[map[nr][nc] - 'A'] = false;
			}
		}
		
		
		
	}

	static boolean isValid(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C)
			return false;
		return true;
	}

}
