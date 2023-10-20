import java.util.*;

class Solution {
    static int N;
    static int M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Node {
        int r;
        int c;
        int depth;
        
        public String toString() {
            return "r: "+r+" c: "+c+" depth: "+depth;
        }
        
        public Node(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        N = maps.length;
        M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        
        int r = 0;
        int c = 0;
        int depth = 1;
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, depth));
        visited[r][c]= true;
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            r = curr.r;
            c = curr.c;
            depth = curr.depth;
            
            if (r == N-1 && c == M-1) {
                answer = Math.min(answer, depth);
            }
            
            for (int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                if (isValid(nr, nc) && !visited[nr][nc] && maps[nr][nc] == 1) {
                    q.add(new Node(nr, nc, depth+1));
                    visited[nr][nc] = true;
                }
            }
            
            
        }
        if (answer == Integer.MAX_VALUE) return -1;
        return answer;
        
    }
    
    public boolean isValid(int r, int c) {
        if (r < 0 || r>=N || c<0 || c>=M) return false;
        return true;
    }
}