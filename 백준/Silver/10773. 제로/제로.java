
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> deq = new LinkedList<>();
		for (int i=0; i<N; i++) {
			int input = sc.nextInt();
			if (input == 0) deq.pollLast();
			else {
				deq.addLast(input);
			}
		}
		int sum = 0;
		if (deq.isEmpty()) System.out.println(sum);
		else {
			for (int d: deq) sum += d;
			System.out.println(sum);
		}
	}

}
