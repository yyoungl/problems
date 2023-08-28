import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (Math.abs(o1) > Math.abs(o2)) return Math.abs(o1) - Math.abs(o2);
				else if (Math.abs(o1) == Math.abs(o2)) {
					return o1-o2;
				} else return -1;
			}
		});
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for (int command=0; command<N; command++) {
			int num = sc.nextInt();
			if (num == 0) {
				if (pq.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(pq.poll()+"\n");
				}
			} else pq.add(num);
		}
		System.out.println(sb.toString());
	}

}
