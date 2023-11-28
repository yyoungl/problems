import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 보석 개수
        int N = sc.nextInt();
        Jewel[] jewels = new Jewel[N];
        // 가방 개수
        int K = sc.nextInt();
        int[] bags = new int[K];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 보석들
        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            int v = sc.nextInt();
            jewels[i] = new Jewel(m, v);
        }
        Arrays.sort(jewels, (o1, o2) -> {
           if (o1.m == o2.m) return o2.v - o1.v;
           else return o1.m - o2.m;
        });
        for (int i = 0; i < K; i++)
            bags[i] = sc.nextInt();
        Arrays.sort(bags);
        int idx = 0;
        long value = 0;

        for (int i=0; i<K; i++) {
            while (idx < N && jewels[idx].m <= bags[i]) {
                pq.add(jewels[idx++].v);
            }

            if (!pq.isEmpty()) {
                value += pq.poll();
            }
        }

        System.out.println(value);
    }

    static class Jewel{
        int m;
        int v;

        public Jewel() {
        }

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }


    }
}
