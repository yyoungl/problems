def solution(brown, yellow):
    answer = []
    total =  brown + yellow
    for i in range(1, yellow+1):
        if yellow % i == 0:
            if 2 * (i + yellow//i) + 4 == brown:
                answer.append(yellow//i + 2)
                answer.append(i+2)
                break

    return answer