def solution(absolutes, signs):
    answer = 0
    n = len(signs)
    for i in range(n):
        if signs[i] == 0:
            answer -= absolutes[i]
        else:
            answer += absolutes[i]
    return answer