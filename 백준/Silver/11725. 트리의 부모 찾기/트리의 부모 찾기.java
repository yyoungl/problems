
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		graph = new ArrayList[N+1];
		parent = new int[N+1];
		for (int i=1; i<=N; i++)
			graph[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			// 자식 노드
			int x = sc.nextInt();
			// 부모 노드
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
		
		dfs(1, -1);
		
		for (int node=2; node<=N; node++) {
			System.out.println(parent[node]);
		}
		
	}
	
	static void dfs(int node, int par) {
		parent[node] = par;
		for (int x: graph[node]) {
			if (x!=par) dfs(x, node);
		}
		
		
	}
	
}
