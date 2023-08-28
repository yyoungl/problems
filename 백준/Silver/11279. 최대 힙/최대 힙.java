
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 연산 개수
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (int command = 0; command < N; command++) {
			// 연산 종류 1: num 추가, 2: 현재 최대 힙의 루트 노드의 키값 출력, 노드 삭제
			int com = sc.nextInt();
			if (com == 0) {
				if (pq.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			} else {
				pq.add(com);
			}
		}
		System.out.println(sb.toString());
	}

}
