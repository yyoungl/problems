
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int answer = -1;
	static int B;
	static int N;
	static int A;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		String[] arr = ("" + A).split("");
		N = arr.length;
		B = sc.nextInt();
		boolean[] chk = new boolean[N];
		if (arr.length > ("" + B).length())
			System.out.println(-1);
		else {
			permutation(chk, arr, "", arr.length);
			System.out.println(answer);

		}

	}

	static void permutation(boolean[] chk, String[] arr, String result, int cnt) {
		if (result.length() == cnt) {
			if (result.charAt(0) == '0') return;
			if (Integer.valueOf(result) < B)
				answer = Math.max(answer, Integer.valueOf(result));
			return;
		}

		for (int i = 0; i < N; i++) {
			if (result.length() == 0 && arr[i].equals("0"))
				continue;
			if (!chk[i]) {
				chk[i] = true;
				permutation(chk, arr, result + arr[i], cnt);
				chk[i] = false;
			}
		}
	}

}
