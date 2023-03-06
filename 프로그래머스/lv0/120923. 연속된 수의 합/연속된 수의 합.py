def solution(num, total):
    answer = []
    
    mid = total/num
    for i in range(0, num):
        if num%2==1:
            answer.append(mid-(num-1)/2+i)
        elif num%2==0:
            answer.append(int(mid-num/2+0.5+i))
        
    
    return answer