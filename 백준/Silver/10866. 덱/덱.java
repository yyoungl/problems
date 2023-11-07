import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		sc.nextLine();
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			String[] str = s.split(" ");
			String command = str[0];
			if (str.length == 2) {
				int value = Integer.valueOf(str[1]);
				if (command.equals("push_front"))
					q.addFirst(value);
				else if (command.equals("push_back"))
					q.addLast(value);
			} else {
				if (command.equals("empty")) {
					if (q.isEmpty())
						sb.append("1\n");
					else
						sb.append("0\n");
				} else if (command.equals("pop_front")) {
					if (q.size() == 0)
						sb.append("-1\n");
					else
						sb.append(q.pollFirst() + "\n");
				} else if (command.equals("pop_back")) {
					if (q.size() == 0)
						sb.append("-1\n");
					else
						sb.append(q.pollLast() + "\n");
				} else if (command.equals("size"))
					sb.append(q.size() + "\n");
				else if (command.equals("front")) {
					if (q.size() == 0)
						sb.append("-1\n");
					else
						sb.append(q.peekFirst() + "\n");
				} else if (command.equals("back")) {
					if (q.size() == 0)
						sb.append("-1\n");
					else
						sb.append(q.peekLast() + "\n");
				}
			}
		}
		System.out.print(sb.toString());
	}

}
