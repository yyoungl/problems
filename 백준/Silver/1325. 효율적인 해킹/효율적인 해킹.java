
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer>[] graph;
	static int[] cnt;
	static boolean[] chk;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		String[] str = s.split(" ");
		N = Integer.valueOf(str[0]);
		M = Integer.valueOf(str[1]);
		graph = new ArrayList[N+1];
		cnt = new int[N+1];
		for (int i=0; i<=N; i++) graph[i] = new ArrayList<>();
		for (int i=0; i<M; i++) {
			s = br.readLine();
			str = s.split(" ");
			int x = Integer.valueOf(str[0]);
			int y = Integer.valueOf(str[1]);
			graph[x].add(y);
		}
		int max = 0;
		for (int i=1; i<=N; i++) {
			chk = new boolean[N+1];
			bfs(i);
		}
		
		for (int i=1; i<=N; i++) {
			max = Math.max(cnt[i], max);
		}
		for (int i=1; i<=N; i++) {
			if (cnt[i] == max) bw.write(i+" ");
		}
		bw.flush();
		
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		chk[start] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for (int node: graph[curr]) {
				if (!chk[node]) {
					chk[node] = true;
					q.add(node);
					cnt[node]++;
				}
			}
		}
		
	}

}
