import java.util.HashSet;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		HashSet<String> chat = new HashSet<>();
		for (int i=0; i<N; i++) {
			String s = sc.next();
			if (s.equals("ENTER")) chat.clear();
			else if (!chat.contains(s)) {
				answer++;
				chat.add(s);
			}
		}
		System.out.println(answer);
	}

}
