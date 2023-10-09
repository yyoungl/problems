class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        boolean[] check = new boolean[arr.length];
        int cnt = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<delete_list.length; j++) {
                if (arr[i] == delete_list[j]) {
                    check[i] = true;
                    cnt++;
                }
            }
        }
        int[] answer = new int[arr.length-cnt];
        int idx = 0;
        for (int i=0; i<arr.length; i++) {
            if (check[i]) continue;
            answer[idx++] = arr[i];
        }
        
        
        return answer;
    }
}