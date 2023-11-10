
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = Integer.MAX_VALUE;
		int F = sc.nextInt(); // 건물 전체 층
		int S = sc.nextInt(); // 현재 위치
		int G = sc.nextInt(); // 목적지
		int U = sc.nextInt(); // 위로 가는 방법
		int D = sc.nextInt(); // 아래로 가는 방법
		int[] elevator = {U, (-1)*D};
		int[] building = new int[F+1];
		boolean[] visited = new boolean[F+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		visited[S] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if (curr == G) {
				answer = building[curr];
				break;
			}
			
			for (int btn: elevator) {
				int next = curr + btn;
				if (next > 0 && next <= F && !visited[next]) {
					q.add(next);
					visited[next] = true;
					building[next] = building[curr] + 1;
				}
			}
			
		}
		
		
		if (answer == Integer.MAX_VALUE) System.out.println("use the stairs");
		else System.out.println(answer);
	}

}
