def solution(numlist, n):
    answer = []
    return sorted(numlist, key=lambda x: (abs(n-x), -x))
    