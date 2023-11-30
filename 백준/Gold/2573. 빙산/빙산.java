import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node {
        int r;
        int c;
        int cnt;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    static int[][] ice;
    static int N;
    static int M;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ice = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ice[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        int time = 0;
        // while문 돌리기
        // 1. 지금 몇 덩어리인지 확인하기 => BFS
        // 덩어리가 한 개면 melt 메소드 돌리고, 아니면 time을 출력
        // 2. melt 메소드: 한번 돌면서 위아래옆 확인하기
        boolean isZero = true;
        while (true) {
            isZero = true;
            cnt = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ice[i][j] > 0) isZero = false;
                    if (!visited[i][j] && ice[i][j] > 0) {
                        BFS(new Node(i, j));
                        cnt++;
                    }
                }
            }
            if (cnt > 1) {
                break;
            }
            if (isZero) break;

            melt();
            time++;
        }
        if (isZero) System.out.println(0);
        else System.out.println(time);
    }


    static void BFS(Node node) {
        Queue<Node> q = new LinkedList<>();
        visited[node.r][node.c] = true;
        q.add(node);
        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                if (isValid(nr, nc) && !visited[nr][nc] && ice[nr][nc] > 0) {
                    q.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }


    }

    static void melt() {
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ice[i][j] > 0) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (isValid(nr, nc) && ice[nr][nc] == 0) cnt++;
                    }
                    if (cnt > 0) q.add(new Node(i, j, cnt));
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (ice[node.r][node.c] - node.cnt < 0) {
                ice[node.r][node.c] = 0;
            } else ice[node.r][node.c] -= node.cnt;
        }

    }

    static boolean isValid(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M) return false;
        return true;
    }
}
