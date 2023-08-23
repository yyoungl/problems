import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] girl = new int[7];
		int[] boy = new int[7];
		
		// 성별, 학년
		// 여0 남1 
		
		for (int i=0; i<N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			if (gender==0) girl[grade]++;
			else boy[grade]++;
		}
		int cnt = 0;
		for (int i=1; i<7; i++) {
			if (girl[i] % K == 0) cnt += girl[i]/K;
			else cnt += girl[i]/K + 1;
			if (boy[i] % K == 0) cnt += boy[i]/K;
			else cnt += boy[i]/K + 1;
		}
		
		System.out.println(cnt);
		
	}

}
