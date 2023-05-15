def solution(s):
    answer = True
    
    stack = []
    for x in s:
        if x == "(":
            stack.append(x)
        else:
            if stack:
                stack.pop()
            else:
                return False
    if stack:
        return False

    return True