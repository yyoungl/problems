def solution(priorities, location):
    count = 0
    first = max(priorities)
    while priorities:
        temp = priorities.pop(0)
        
        if temp == first:
            count += 1
            if location == 0 :
                break
            else:
                location -= 1
            first = max(priorities)
        else:
            priorities.append(temp)
            if location == 0:
                location = len(priorities) - 1
            else:
                location -= 1
    return count