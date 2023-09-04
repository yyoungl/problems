import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int D;
	static int W;
	static int K;
	static boolean[] chk;
	static boolean[][] film;
	static boolean[][] OFilm;
	static boolean[] A;
	static boolean[] B;
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			answer = K;
			// true면 B false면 A
			film = new boolean[D][W];
			OFilm = new boolean[D][W];
			A = new boolean[W];
			B = new boolean[W];
			for (int i=0; i<W; i++) {
				B[i] = true;
			}
			
			chk = new boolean[D];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					int temp = sc.nextInt();
					if (temp == 1) {
						film[i][j] = true;
						OFilm[i][j] = true;
					} else {
						film[i][j] = false;
						OFilm[i][j] = false;
					}
				}
			}

			int[] result = new int[K];
			boolean[] ab = new boolean[K];
			combination(0, 0, result, ab);
			System.out.println("#" + test_case + " " + answer);
		}

	}


	public static void combination(int cnt, int start, int[] result, boolean[] ab) {
		if (cnt >= answer || cnt==K) return;
        boolean temp = false;
		temp = binary(cnt, ab, result);
		if (temp) {
			answer = Math.min(answer, cnt);
		}
		
				
		for (int i = start; i < D; i++) {
			result[cnt] = i;
			ab[cnt] = true;
			combination(cnt + 1, i + 1, result, ab);
			ab[cnt] = false;
			combination(cnt + 1, i + 1, result, ab);
		}
	}

	public static boolean binary(int num, boolean[] ab, int[] result) {
		for (int i = 0; i < num; i++) {
			int r = result[i];
			boolean set = ab[i];
			if (set) film[r] = B;
			else film[r] = A;
		}
		boolean chkResult = filmChk(film);
		for (int i=0; i<num; i++) {
			int r = result[i];
			film[r] = OFilm[r];
		}
		return chkResult;
	}
	
	
	public static boolean filmChk(boolean[][] film) {
		boolean[] chk = new boolean[W];
		boolean answer = true;
		for (int c = 0; c < W; c++) {
			boolean isOkay = false;
			int cnt = 1;
			for (int r = 1; r < D; r++) {
				if (film[r - 1][c] == film[r][c])
					cnt++;
				else
					cnt = 1;
				if (cnt >= K)
					isOkay = true;
			}
			if (isOkay)
				chk[c] = true;
		}
		for (int i = 0; i < W; i++) {
			if (!chk[i])
			{
				answer = false;
				break;
			}
		}
		return answer;
	}

}
