class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        int pro = 1;
        for (int i=0; i<num_list.length; i++) {
            sum += num_list[i];
            pro *= num_list[i];
        }
        if (pro < sum*sum) return 1;
        return 0;
    }
}