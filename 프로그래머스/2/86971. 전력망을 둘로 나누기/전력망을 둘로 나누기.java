import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] w: wires) {
            int a = w[0];
            int b = w[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int[] w: wires) {
            int a = w[0];
            int b = w[1];
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            answer = Math.min(answer, Math.abs(bfs(a, n) - bfs(b, n)));
            graph[a].add(b);
            graph[b].add(a);
        }
        
        
        
        return answer;
    }
    
    static int bfs(int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(start);
        int curr = start;
        visited[curr] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            curr = q.poll();
            for(int node: graph[curr]) {
                if (!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}