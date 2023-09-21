import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder s = new StringBuilder();
		String input = sc.next();
		Deque<Character> q = new LinkedList<>();
		q.add(input.charAt(0));
		for (int i=1; i<input.length(); i++) {
			if (q.peekFirst() >= input.charAt(i)) q.addFirst(input.charAt(i));
			else q.addLast(input.charAt(i));
		}
		
		for (char c: q) System.out.print(c);
	}

}
