import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> q =  new LinkedList<>();
		int N = sc.nextInt();

		for (int i=1; i<=N; i++) {
			int card = sc.nextInt();
			q.add(card, i);
		}
		
		for (int i=N-1; i>=0; i--) {
			System.out.print(q.get(i)+" ");
		}
		
	}

}
