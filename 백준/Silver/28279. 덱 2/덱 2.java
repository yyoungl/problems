
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deq = new ArrayDeque<>();
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int com = 0; com < N; com++) {
			int c = sc.nextInt();
			switch (c) {
			case 1:
				int num = sc.nextInt();
				deq.addFirst(num);
				break;
			case 2:
				num = sc.nextInt();
				deq.addLast(num);
				break;
			case 3:
				if (deq.isEmpty())
					sb.append("-1\n");
				else {
					sb.append(+deq.pollFirst()+"\n");
				}
				break;
			case 4:
				if (deq.isEmpty())
					sb.append("-1\n");
				else {
					sb.append(deq.pollLast()+"\n");
				}
				break;
			case 5: 
				sb.append(deq.size()+"\n");
				break;
			case 6:
				if (deq.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case 7:
				if (deq.isEmpty()) sb.append("-1\n");
				else sb.append(deq.peekFirst()+"\n");
				break;
			case 8:
				if (deq.isEmpty()) sb.append("-1\n");
				else sb.append(deq.peekLast()+"\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
