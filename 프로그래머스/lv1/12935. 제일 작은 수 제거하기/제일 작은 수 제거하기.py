def solution(arr):
    answer = []
    answer = arr
    answer.remove(min(arr))
    if len(answer) == 0:
        answer = [-1]
    return answer