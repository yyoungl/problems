def solution(n, lost, reserve):
    lost2 = set(lost) - set(reserve)
    reserve2 = set(reserve) - set(lost)
    
    for i in reserve2:
        if i - 1 in lost2:
            lost2.remove(i-1)
        elif i + 1 in lost2:
            lost2.remove(i+1)
            
    return n-len(lost2)