
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] family;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사람의 수
		N = sc.nextInt();
		visited = new boolean[N+1];
		int person1 = sc.nextInt();
		int person2 = sc.nextInt();
		family = new int[N+1][N+1];
		int edges = sc.nextInt();
		
		for (int i=0; i<edges; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			family[x][y] = 1;
			family[y][x] = 1;
		}
		
		System.out.println(chon(0, person1, person2));
		
		
	}
	
	static int chon(int depth, int person1, int person2) {
		if (person1 == person2) return depth;
		visited[person1] = true;
		int min = -1;
		
		for (int i=1; i<=N; i++) {
			if (family[person1][i] == 1 && !visited[i]) {
				int c = chon(depth+1, i, person2);
				if (c!=-1) {
					if (min == -1 || c < min) min = c ;
				}
			}
		}
		visited[person1] = false;
		return min;		
	}

}
