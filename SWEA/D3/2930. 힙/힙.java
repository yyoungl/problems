import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			sb.append("#"+test_case+" ");
			// 연산 개수
			int N = sc.nextInt();
			for (int command=0; command<N; command++) {
				// 연산 종류 1: num 추가, 2: 현재 최대 힙의 루트 노드의 키값 출력, 노드 삭제
				int com = sc.nextInt();
				if (com==1) {
					int num = sc.nextInt();
					pq.add(num);
				}
				else if (com==2) {
					if (pq.isEmpty()) {
						sb.append("-1 ");
					}
					else {
						sb.append(pq.poll()+ " ");
					}
				}
			}
			System.out.println(sb.toString());
		}
    }
}
