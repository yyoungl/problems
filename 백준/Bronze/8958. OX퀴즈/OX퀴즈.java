
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int tc=0; tc<N; tc++) {
			char[] answer = sc.next().toCharArray();
			int[] score = new int[answer.length];
			
			if (answer[0] == 'O') score[0]++;
			int sum = score[0];
			for (int i=1; i<answer.length; i++) {
				if (answer[i] == 'O') score[i] = score[i-1]+1;
				sum += score[i];
			}
			System.out.println(sum);
		}
		
	}

}
