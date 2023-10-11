
import java.util.Scanner;

public class Main {
	static int[][] ability = new int[11][11];
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc=1; tc<=T; tc++) {
			answer = 0;
			for (int i=0; i<11; i++) {
				for (int j=0; j<11; j++) 
					ability[i][j] = sc.nextInt();
			}
			
			boolean[] visited = new boolean[11];
			int[] list = new int[11]; // 인덱스: 선수 번호, 값: 포지션
			permutation(0, 0, visited, list);
			System.out.println(answer);
		}
	}
	
	public static void permutation (int sum, int idx, boolean[] visited, int[] list) {
		if (idx == 11) {
			answer = Math.max(sum, answer);
			return;
		}
		
		for (int i=0; i<11; i++) {
			int abil = ability[idx][i];
			if (!visited[i] && abil > 0) {
				visited[i] = true;
				list[idx] = i;
				permutation(sum+abil, idx+1, visited, list);
				visited[i] = false;
			}
		}
	}

}
