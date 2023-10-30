
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int answer = 0;
	static int[] arr;
	static int find;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		find = sc.nextInt();
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == find) answer++;
		}
		for (int cnt=2; cnt<=N; cnt++) {
			boolean[] chk = new boolean[N];
			int[] result = new int[cnt];
			combination(N, cnt, 0, result, 0, chk);
			
		}
		System.out.println(answer);
	}

	static void combination(int N, int cnt, int idx, int[] result, int start, boolean[] chk) {
		if (idx == cnt) {
			int sum = 0;
			for (int i=0; i<cnt; i++) {
				sum += arr[result[i]];
			}	
			if (sum == find) answer++;
			return;
		}
		
		for (int i=start; i<N; i++) {
			if (!chk[i]) {
				chk[i] = true;
				result[idx] = i;
				combination(N, cnt, idx+1, result, i+1, chk);
				chk[i] = false;
			}
		}
	}
}