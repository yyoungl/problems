import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] chars = sc.next().toCharArray();
		int[] answer = new int[26];
		for (char c : chars) {
			int idx = Integer.valueOf(c)-97;
			answer[idx]++;
		}
		
		for (int i: answer) {
			System.out.print(i+" ");
		}
	}

}
