import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int R = Integer.parseInt(sc.next());
			int C = Integer.parseInt(sc.next());
			char[][] map = new char[R][C];
			int r = 0;
			int c = 0;
			int dr = 0;
			int dc = 0;
			for (int i = 0; i < R; i++) {
				String str = sc.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '^') {
						r = i;
						c = j;
						dr = -1;
						dc = 0;
					} else if (map[i][j] == '<') {
						r = i;
						c = j;
						dr = 0;
						dc = -1;
					} else if (map[i][j] == 'v') {
						r = i;
						c = j;
						dr = 1;
						dc = 0;
					} else if (map[i][j] == '>') {
						r = i;
						c = j;
						dr = 0;
						dc = 1;
					}
				}
			}

			int N = Integer.parseInt(sc.next());
			char[] command = new char[N];
			String str = sc.next();
			for (int i = 0; i < N; i++)
				command[i] = str.charAt(i);

			for (char com : command) {
				if (com == 'U') {
					map[r][c] = '^';
					dr = -1;
					dc = 0;
					if (r + dr >= 0 && r + dr < R && c + dc >= 0 && c + dc < C && map[r + dr][c + dc] == '.') {
						map[r][c] = '.';
						map[r + dr][c + dc] = '^';
						r += dr;
						c += dc;
					}
				} else if (com == 'D') {
					map[r][c] = 'v';
					dr = 1;
					dc = 0;
					if (r + dr >= 0 && r + dr < R && c + dc >= 0 && c + dc < C && map[r + dr][c + dc] == '.') {
						map[r][c] = '.';
						map[r + dr][c + dc] = 'v';
						r += dr;
						c += dc;
					}
				} else if (com == 'R') {
					map[r][c] = '>';
					dr = 0;
					dc = 1;
					if (r + dr >= 0 && r + dr < R && c + dc >= 0 && c + dc < C && map[r + dr][c + dc] == '.') {
						map[r][c] = '.';
						map[r + dr][c + dc] = '>';
						r += dr;
						c += dc;
					}
				} else if (com == 'L') {
					map[r][c] = '<';
					dr = 0;
					dc = -1;
					if (r + dr >= 0 && r + dr < R && c + dc >= 0 && c + dc < C && map[r + dr][c + dc] == '.') {
						map[r][c] = '.';
						map[r + dr][c + dc] = '<';
						r += dr;
						c += dc;
					}
				} else if (com == 'S') {
					int bombR = r;
					int bombC = c;
					while (true) {
						if (bombR + dr >= 0 && bombR + dr < R && bombC + dc >= 0 && bombC + dc < C) {
							if (map[bombR + dr][bombC + dc] == '#')
								break;
							else if (map[bombR + dr][bombC + dc] == '*') {
								map[bombR + dr][bombC + dc] = '.';
								break;
							} else {
								bombR += dr;
								bombC += dc;
							}
						} else break;
					}
				}
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}
		}
	}

}
