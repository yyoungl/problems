def solution(a, b, n):
    answer = 0
    while n//a > 0 :
        bottles = n%a
        n = (n//a) * b
        answer += n
        n += bottles
    return answer