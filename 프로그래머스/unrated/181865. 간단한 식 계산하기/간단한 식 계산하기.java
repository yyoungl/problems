import java.util.*;

class Solution {
    public int solution(String binomial) {
        String[] values = binomial.split(" ");
        System.out.println(Arrays.toString(values));
        int a = Integer.valueOf(values[0]);
        int b = Integer.valueOf(values[2]);
        char flag = values[1].charAt(0);
        switch (flag) {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
        }
        return 0;
    }
}