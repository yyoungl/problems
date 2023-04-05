def solution(a, b):
    if a < b:
        answer = sum(range(a, b+1))
    elif a > b :
        answer = sum(range(b, a+1))
    else:
        return a
    return answer