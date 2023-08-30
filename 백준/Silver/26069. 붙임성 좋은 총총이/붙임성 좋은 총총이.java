import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<String> dance = new HashSet<>();
		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			String a = sc.next();
			String b = sc.next();
			if (a.equals("ChongChong") || b.equals("ChongChong")) {
				dance.add(a);
				dance.add(b);
				continue;
			}
			if (dance.contains(a)) dance.add(b);
			else if (dance.contains(b)) dance.add(a);
		}
		
		System.out.println(dance.size());
	}

}
