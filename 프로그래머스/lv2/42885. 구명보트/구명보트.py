from collections import deque

def solution(people, limit):
    answer = 0
    people.sort() # 오름차순 정렬
    q = deque(people) # queue 자료구조로 만들어줌
    
    while q: # q = 대기열
        if len(q) >= 2:
            if q[0] + q[-1] <= limit:
                q.pop()
                q.popleft()
                answer+=1
            elif q[0] + q[-1] > limit:
                q.pop() # q[-1] 없애는 
                answer+=1
        else:

            q.pop()
            answer +=1
                
                
    
    return answer