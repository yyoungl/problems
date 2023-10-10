class Solution {
    public int[] solution(int[] arr, int[][] queries) {

        int N = queries.length;
        for (int i=0; i<N; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        int[] answer = arr;
        
        return answer;
    }
}