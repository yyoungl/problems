import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static class Cloud {
		int r;
		int c;

		public Cloud(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Cloud [r=" + r + ", c=" + c + "]";
		}

	}

	static int N;
	static int M;
	static boolean[][] cloud;
	static int[][] map;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[][] commands; // {방향, 거리};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cloud = new boolean[N][N];
		map = new int[N][N];
		commands = new int[M][2];
		ArrayList<Cloud> clouds = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			commands[i][0] = sc.nextInt() - 1;
			commands[i][1] = sc.nextInt();
		}

		clouds.add(new Cloud(N - 2, 0));
		clouds.add(new Cloud(N - 2, 1));
		clouds.add(new Cloud(N - 1, 0));
		clouds.add(new Cloud(N - 1, 1));

		cloud[N - 2][0] = true;
		cloud[N - 2][1] = true;
		cloud[N - 1][0] = true;
		cloud[N - 1][1] = true;

		for (int[] command : commands) {
			int d = command[0];
			int s = command[1];
			int size = clouds.size();
			// 이동하기
			for (int i = 0; i < size; i++) {
				Cloud curr = clouds.get(i);
				cloud[curr.r][curr.c] = false;
				int nr = (curr.r + s * dr[d] + 50 * N) % N;
				int nc = (curr.c + s * dc[d] + 50 * N) % N;
				curr.r = nr;
				curr.c = nc;
				map[nr][nc] += 1;
			}
			
			
			for (Cloud curr: clouds) {
				int r = curr.r;
				int c = curr.c;
				cloud[r][c] = true;
				int cnt = 0;
				for (int dir = 1; dir < 8; dir += 2) {
					int nr = r+dr[dir];
					int nc = c+dc[dir];
					if (isValid(nr, nc) && map[nr][nc] > 0) {
						cnt++;
					}
				}
				map[r][c] += cnt;
			}

			clouds.clear();
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] >= 2 && !cloud[r][c]) {
						clouds.add(new Cloud(r, c));
						map[r][c] -= 2;
					}
				}
			}
			
			cloud = new boolean[N][N];
			for (Cloud c : clouds) {
				cloud[c.r][c.c] = true;
			}


		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				answer += map[i][j];
		}

		System.out.println(answer);

	}

	static boolean isValid(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N)
			return false;
		return true;
	}

}
