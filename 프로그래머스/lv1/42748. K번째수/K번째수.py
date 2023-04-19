def solution(array, commands):
    answer = []
    for x in commands:
        answer.append(sorted(array[x[0]-1:x[1]])[x[2]-1])
    return answer