from collections import deque

N, K = map(int, input().split())
que = [x for x in range(1, N+1)]
que = deque(que)
answer= []

while que:
    for _ in range(K-1):
        temp = que.popleft()
        que.append(temp)
        
    answer.append(que.popleft())
    
print("<" + ", ".join(map(str, answer)) + ">")