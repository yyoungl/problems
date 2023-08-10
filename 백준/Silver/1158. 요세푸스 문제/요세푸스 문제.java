import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();

		for (int i=1; i<N+1; i++) {
			q.offer(i);
		}
		
		System.out.print("<");
		while (!q.isEmpty()) {
			for (int i=0; i<K-1; i++) {
				q.offer(q.poll());
			}
			if (q.size()>1) {
				System.out.print(q.poll() + ", ");
			} else System.out.print(q.poll());
		}
		
		System.out.print(">");
		
	}

}
