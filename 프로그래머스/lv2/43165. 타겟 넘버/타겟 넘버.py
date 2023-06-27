# BFS로 푸는 방법
def solution(numbers, target):
    answer = 0
    result = [0]
    for num in numbers:
        temp = []
        for i in result:
            temp.append(i+num)
            temp.append(i-num)
        result = temp
    for x in result:
        if x == target:
            answer+=1

    return answer

# DFS로 푸는 방법 공부하기