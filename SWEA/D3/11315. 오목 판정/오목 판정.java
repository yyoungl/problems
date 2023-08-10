import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] dr = { 1, 1, 0, 1 };
			int[] dc = { 0, 1, 1, -1 };
			boolean isOkay = false;

			String[][] board = new String[N][N];
			for (int i = 0; i < N; i++) {

				String inputS = sc.next();
				String[] in = inputS.split("");
				board[i] = in;

			}
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c].equals(".")) {
						continue;
					}
					for (int d = 0; d < 4; d++) {
							boolean flag = check(r, c, board, dr[d], dc[d], 0, N);
							if (flag) {
								isOkay = true;
								break;
						}
					}
				}
			}
			
			if (isOkay)
				System.out.println("#"+test_case+" YES");
			else
				System.out.println("#"+test_case+" NO");
		}
	}

	static boolean check(int r, int c, String[][] board, int dr, int dc, int cnt, int N) {
		cnt++;
		if (cnt == 5) {
			return true;
		}

		if (r + dr >= 0 && r + dr < N && c + dc >= 0 && c + dc < N && board[r + dr][c + dc].equals("o")) {
			return check(r + dr, c + dc, board, dr, dc, cnt, N);
		}

		return false;
	}
}