class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        int N = queries.length;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<queries.length; j++)
                if (i >= queries[j][0] && i<=queries[j][1]) answer[i]++;
        }
        return answer;
    }
}