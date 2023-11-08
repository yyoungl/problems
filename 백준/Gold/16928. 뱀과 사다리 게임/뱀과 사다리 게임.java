
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] jump = new int[101];
		int[] cnt = new int[101];
		Arrays.fill(cnt, Integer.MAX_VALUE);
		int N = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 0; i < N + M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			jump[x] = y;
		}
		
		cnt[1] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (curr == 100)
				break;
			for (int d = 1; d <= 6; d++) {
				int next = curr + d;
				if (next > 100)
					continue;
				if (jump[next] > 0) {
					if (cnt[jump[next]] > cnt[curr] + 1) {
						cnt[jump[next]] = cnt[curr] + 1;
						q.add(jump[next]);
					}
				} else {
					if (cnt[next] > cnt[curr] + 1) {
						q.add(next);
						cnt[next] = cnt[curr] + 1;
					}
				}
			}
		}
		
		System.out.println(cnt[100]);

	}

}
