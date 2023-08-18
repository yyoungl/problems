class Solution {
    static int cnt = 0;
    public int solution(int n) {

        int[] points = new int[n];
		bt(0, n, points);

        return cnt;
    }
    
    static void bt(int r, int N, int[] points) {
		// bt (r+1, N,  ...);
		if(r == N) {
			cnt++;
			return;
		}
		for (int dc = 0; dc<N; dc++) {
			boolean check = true;
			for (int i=0; i<r; i++) { 
				if ( points[i]== dc || ((r-i) == Math.abs(points[i]-dc))) {
					check=false;
				}
			}
			if (check) {
				points[r] = dc;
				bt(r+1, N, points);
			}
			
		}
		
	}
}