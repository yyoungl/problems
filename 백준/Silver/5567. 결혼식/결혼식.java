
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int num;
		int depth;
		public Node(int num, int depth) {
			super();
			this.num = num;
			this.depth = depth;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", depth=" + depth + "]";
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer>[] friends = new ArrayList[N+1];
		int link = sc.nextInt();
		boolean[] visited = new boolean[N+1];
		for (int i=0; i<=N; i++) friends[i] = new ArrayList<>();
		
		for (int i=0; i<link; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			friends[x].add(y);
			friends[y].add(x);
		}
		
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			int me = curr.num;
			int depth = curr.depth;
			if (depth>=2) continue;
			
			for (int friend: friends[me]) {
				if (!visited[friend] && depth<2) {
					q.add(new Node(friend, depth+1));
					visited[friend] = true;
				}
			}
		}
		int cnt = 0;
		for (int i=2; i<=N; i++) {
			if (visited[i]) cnt++;
		}
		System.out.println(cnt);
		
	}

}
