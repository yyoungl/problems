function solution(sides) {
    var answer = 0;
    let i, max, min;
// 둘 중 긴 변, 짧은 변 찾기
    if (sides[0]>sides[1])
    {
        max = sides[0];
        min=sides[1];
    }
    else
    {
        max = sides[1];
        min = sides[0];
    }
    
// 첫 번째 경우 min < i < max
    for (i=1; i<max; i++)
    {
        if (i<min+max && min < i+max && max < i+min && i>max-min && min > max-i && max > i-min)
            answer = answer+1 ;
        else
            answer = answer;
    }

// 두 번째 경우 min < max < i
    for (i=max; i<min+max ; i++)
    {
        if (i<min+max && min < i+max && max < i+min && i>max-min && min > max-i && max > i-min)
            answer = answer+1 ;
        else
            answer = answer;
    }
    
    
    
    return answer;
}