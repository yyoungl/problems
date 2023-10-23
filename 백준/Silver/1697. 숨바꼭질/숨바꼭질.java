
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int end;
	static int start;
	static class Pos {
		int p;
		int depth;
		public Pos(int p, int depth) {
			super();
			this.p = p;
			this.depth = depth;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		start = sc.nextInt();
		end = sc.nextInt();
		boolean[] visited = new boolean[100001];
		int answer = Integer.MAX_VALUE;
		Queue<Pos> q = new LinkedList<>();
		
		q.add(new Pos(start, 0));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			int p = curr.p;
			int dep = curr.depth;
			if (p == end) answer = Math.min(dep, answer);
			
			if (isValid(p-1) && !visited[p-1]) {
				visited[p-1] = true;
				q.add(new Pos(p-1, dep+1));
			}
			if (isValid(p+1) && !visited[p+1]) {
				visited[p+1] = true;
				q.add(new Pos(p+1, dep+1));
			}
			if (isValid(p*2) && !visited[p*2]) {
				visited[p*2] = true;
				q.add(new Pos(p*2, dep+1));
			}
			
		}
		
		
		System.out.println(answer);
	}
	
	static boolean isValid(int p) {
		if (p<0 || p>=100001) return false;
		return true;
	}


}
