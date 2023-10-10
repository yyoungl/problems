class Solution {
    static int N;
	static int answer;
	static boolean answerFlag;
	static int wLen;
	static boolean[][] graph;
	static int solution(String begin, String target, String[] words) {
		N = begin.length();
		wLen = words.length;
		
		boolean beginChk = false;
        boolean targetChk = false;
		for (int i=0; i<wLen; i++) {
			if (begin.equals(words[i])) beginChk = true;
			if (target.equals(words[i])) targetChk = true;
		}
		
		System.out.println(beginChk+" "+targetChk);
		
		if (!targetChk) return 0;
		
		answer = wLen;
		graph = new boolean[wLen][wLen];

		for (int i = 0; i < wLen; i++) {
			for (int j = 0; j < wLen; j++) {
				if (i == j)
					continue;
				if (chk(words[i], words[j]))
					graph[i][j] = graph[j][i] = true;
			}
		}
		
		
		int beginIdx = 0;
		int targetIdx = 0;
		for(int i=0; i<wLen; i++) {
			if (words[i].equals(begin)) beginIdx = i;
			if (words[i].equals(target)) targetIdx = i;
		}
		boolean[] visited = new boolean[wLen];
		
		if (!beginChk) {
			for (int i=0; i<wLen; i++) {
				if (chk(begin, words[i])) {
					System.out.println("여기"+begin+" words[i]: "+words[i]);
					dfs(i, targetIdx, i, 1, words, visited);
				}
			}
		}
		
		else {
			dfs(beginIdx, targetIdx, beginIdx, 0, words, visited);
		}
		
		if (answer == wLen) return 0;
		return answer;
	}

	static boolean chk(String s1, String s2) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (s1.charAt(i) == s2.charAt(i))
				cnt++;
		}
		if (cnt == N - 1)
			return true;
		return false;
	}
	
	static void dfs(int begin, int target, int curr, int cnt, String[] words, boolean[] visited) {
		if (curr == target) {
//			System.out.println("answer: "+answer);
//			System.out.println("cnt: "+cnt);
			answer = Math.min(answer, cnt);
			return;
		}
		if (cnt >=wLen || visited[curr]) return;
//		System.out.println("curr: "+curr+" words[curr]: "+words[curr]);
		visited[curr] = true;
		
		for (int i=0; i<wLen; i++) {
			if (curr==i) continue;
			if (graph[i][curr] && !visited[i]) {
				
				dfs(begin, target, i, cnt+1, words, visited);
			}
		}
		
	}
}