
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		while (N>0) {
			if (N%5 == 0) {
				answer += N/5;
				break;
			}
			else if (N==1) {
				answer = -1;
				break;
			} else {
				N -= 2;
				answer++;
			}
		}
		System.out.println(answer);
	}

}
