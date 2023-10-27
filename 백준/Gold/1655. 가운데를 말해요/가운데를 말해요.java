
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> big = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int in;
		for (int i = 0; i < N; i++) {
			in = Integer.valueOf(br.readLine());
			if (i == 0) {
				small.add(in);
			} else if (i % 2 == 0) {
				if (in > big.peek()) {
					small.add(big.poll());
					big.add(in);
				} else
					small.add(in);

			} else {
				if (small.peek() > in) {
					big.add(small.poll());
					small.add(in);
				} else {
					big.add(in);

				}
			}
			sb.append(small.peek() + "\n");
//
//			System.out.print("small: ");
//			for (int num: small) System.out.print(num+" ");
//			System.out.println();
//			System.out.print("big: ");
//			for (int num: big) System.out.print(num +" ");
//			System.out.println();
		}
		System.out.println(sb.toString());
	}

}
