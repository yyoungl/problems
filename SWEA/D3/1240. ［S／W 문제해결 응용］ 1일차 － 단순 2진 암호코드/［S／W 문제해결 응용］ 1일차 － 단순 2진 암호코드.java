import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(sc.next());
			int M = Integer.parseInt(sc.next());
			int[][] code = new int[N][M];
			String codeS = "";
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				boolean isZero = true;
				for (int j = 0; j < M; j++) {
					if (s.charAt(j) == '1')
						isZero = false;

				}
				if (!isZero)
					codeS = s;
			}

			int end = M - 1;
			for (int idx = M - 1; idx >= 0; idx--) {
				if (codeS.charAt(idx) == '1') {
					end = idx;
					break;
				}
			}

			int startIdx = end - 55;
			String[] codeString = new String[8];
			int idx = 0;

			int[] codeArr = new int[8];

			for (int i = startIdx; i < end; i += 7) {
				String s = "";
				for (int j = i; j < i + 7; j++) {
					s += codeS.charAt(j);
				}
				codeString[idx++] = s;
			}

			int oddSum = 0;
			int evenSum = 0;

			for (int i = 0; i < 8; i++) {
				codeArr[i] = solve(codeString[i]);
				if (i % 2 == 0)
					oddSum += codeArr[i];
				else
					evenSum += codeArr[i];
			}

			int sum = oddSum * 3 + evenSum;

			if (sum % 10 == 0)
				System.out.println("#" + test_case + " " + (oddSum + evenSum));
			else
				System.out.println("#" + test_case + " 0");

		}
	}

	public static int solve(String code) {
		if (code.equals("0001101"))
			return 0;
		else if (code.equals("0011001"))
			return 1;
		else if (code.equals("0010011"))
			return 2;
		else if (code.equals("0111101"))
			return 3;
		else if (code.equals("0100011"))
			return 4;
		else if (code.equals("0110001"))
			return 5;
		else if (code.equals("0101111"))
			return 6;
		else if (code.equals("0111011"))
			return 7;
		else if (code.equals("0110111"))
			return 8;
		else
			return 9;
	}

}
