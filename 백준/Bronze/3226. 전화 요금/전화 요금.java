import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.valueOf(sc.nextLine());
		int answer = 0;
		
		for (int i=0; i<N; i++) {
			String[] call = sc.nextLine().split(" ");
			String[] time = call[0].split(":");
			int t = Integer.valueOf(call[1]);
			
			int hour = Integer.parseInt(time[0]);
			int minute = Integer.parseInt(time[1]);
			
			if (minute+t >=60 && hour == 6) {
				answer += (60-minute) * 5;
				answer += (minute+t-60) * 10;
			}
			
			else if (minute+t >=60 && hour == 18) {
				answer += (60-minute) * 10;
				answer += (minute+t-60) * 5;
			}
			
			else if (hour >= 7 && hour < 19) answer += t*10;
			else answer += t*5;
			
		}
		
		System.out.println(answer);
	}

}
