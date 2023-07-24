def solution(lines):

    line = [0] * 200
    for x, y in lines:
        for j in range(x, y):
            line[j+100] +=1
    
    line = list(filter(lambda x: x>1, line))

    return len(line)
