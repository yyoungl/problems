def solution(citations):
    answer = 0
    citations.sort(reverse = True)
    n = len(citations)
    for i in range(n):
        if citations[i] < i+1 :
            return answer
            break
        # citation[i] >= i+1
        answer+=1
    return answer



