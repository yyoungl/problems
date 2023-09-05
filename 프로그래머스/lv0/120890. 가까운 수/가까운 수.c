#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// array_len은 배열 array의 길이입니다.
int solution(int array[], size_t array_len, int n) {
    int answer = 0;
    int i, sub, min=9999;
    for (i=0; i<array_len;i++)
    {
        sub = abs(n-array[i]);
        
        if (min>sub)
        {
            min=sub;
            answer=array[i];
        }
        
        else if (min==sub && array[i]<answer)
        {
            answer=array[i];
        }
        

    }
        
    return answer;
}