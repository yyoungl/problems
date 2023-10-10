import java.util.*;

public class Main {
	static int N;
	static int[] popul;
	static ArrayList<Integer>[] graph;
	static int answer = 0;
	static boolean[] chk;
	static int totalP = 0;
	static boolean answerFlag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		popul = new int[N + 1];
		graph = new ArrayList[N + 1];
		chk = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			popul[i] = sc.nextInt();
			graph[i] = new ArrayList<>();
			answer += popul[i];
		}
		
		totalP = answer;

		for (int i = 1; i <= N; i++) {
			int link = sc.nextInt();
			for (int idx=0; idx<link; idx++) {
				graph[i].add(sc.nextInt());
			}
		}
		
		int half = 0;
		if ( N % 2 == 0) {
			half = N/2;
		} else {
			half = N/2 +1 ;
		}
		
		for (int cnt=1; cnt<=half; cnt++) {
			int[] comb1 = new int[cnt];
			combination(cnt, 0, comb1, 1);
		}
		if (!answerFlag) System.out.println(-1);
		else System.out.println(answer);

	}
	
	static void combination(int cnt, int idx, int[] tempArr, int start) {
		if (idx == cnt) {
			int[] region1 = Arrays.copyOf(tempArr, cnt);
			
			if(linkChk(region1)) {
				answerFlag = true;
				int sum1 = 0;
				for (int i: region1) {
					sum1 += popul[i];
				}
//				System.out.println("totalP, sum1: "+totalP+" "+sum1);
				answer = Math.min(answer, Math.abs((totalP - sum1)-sum1));
			}
			
			return;
		}
		for (int i=start; i<=N; i++) {
			if (!chk[i]) {
				chk[i] = true;
				tempArr[idx] = i;
				combination(cnt, idx+1, tempArr, i+1);
				chk[i] = false;
			}
			
		}
	}
	
	static boolean linkChk(int[] region1) {
		boolean[] visited = new boolean[N+1];
		boolean[] tempChk = new boolean[N+1];
		int[] region2 = new int[N-region1.length];
//		System.out.println("확인 전: "+Arrays.toString(visited));
		
		// 두 번째 지역 만들기
		int idx = 0;
		for (int i: region1) {
			tempChk[i] = true;
		}
		
		for (int i=1; i<=N; i++) {
			if (!tempChk[i]) region2[idx++] = i;
		}
		
		// bfs
		// 1번 구역 확인
		Queue<Integer> q = new LinkedList<>();
		q.add(region1[0]);
		visited[region1[0]] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for (int i: graph[curr]) {
				if (!visited[i] && tempChk[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		// 2번 구역 확인
		q = new LinkedList<>();
		q.add(region2[0]);
		visited[region2[0]] = true;
		while(!q.isEmpty()) {
			int curr = q.poll();
			for (int i: graph[curr]) {
				if (!visited[i] && !tempChk[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
//		System.out.println("region1: "+Arrays.toString(region1));
//		System.out.println("region2: "+Arrays.toString(region2));
		
//		System.out.println(Arrays.toString(visited));
		
		// 모두 방문 체크 되어있는지 체크
		for (int i=1; i<=N; i++) {
			if (!visited[i]) return false;
		}
		
		return true;
	}
	
	
}