import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 10;
		int answer = 0;
		int now = 0;
		
		while (N-->0) {
			int out = sc.nextInt();
			int in = sc.nextInt();
			
			now -= out;
			answer = Math.max(answer, now);
			now += in;
			answer = Math.max(answer, now);
			
		}
		System.out.println(answer);
		
	}

}
