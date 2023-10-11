import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 강의실 배정
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int N = sc.nextInt();
		long[][] times = new long[N][2];

		for (int i = 0; i < N; i++) {
			times[i][0] = sc.nextLong();
			times[i][1] = sc.nextLong();
		}

		Arrays.sort(times, (o1, o2) -> {
			if (o1[0] == o2[0])
				return Long.compare(o1[1], o1[1]);
			else
				return Long.compare(o1[0], o2[0]);
		});

		pq.add(times[0][1]);
		for (int i = 1; i < N; i++) {
			if (pq.peek() <= times[i][0]) {
				pq.poll();
				pq.add(times[i][1]);
			}
			else pq.add(times[i][1]);
		}

		System.out.println(pq.size());

	}

}
