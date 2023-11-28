import java.util.*;

public class Main {
    static int N;
    static int answer;
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            answer = N;
            students = new int[N+1];
            visited = new boolean[N+1];
            finished = new boolean[N+1];
            for (int i=1; i<=N; i++) students[i] = sc.nextInt();
            for (int i=1; i<=N; i++) {
                if(!visited[i]) dfs(i);
            }
            System.out.println(answer);
        }
    }

    static void dfs(int now) {
        visited[now] = true;
        int next = students[now];

        if (!visited[next]) dfs(next);
        else {
            if (!finished[next]) {
                answer--;
            while (next != now) {
                next = students[next];
                answer--;
            }
            }
        }
        finished[now] = true;
    }
}
