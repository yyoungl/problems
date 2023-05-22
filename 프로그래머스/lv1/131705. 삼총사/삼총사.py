from itertools import combinations
def solution(number):
    answer = 0
    comb = list(combinations(number, 3))
    for x in comb:
        if sum(x) == 0:
            answer+=1
    return answer