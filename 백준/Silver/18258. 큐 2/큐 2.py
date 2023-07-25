from sys import stdin
from collections import deque

q = deque([])
n = int(stdin.readline())
# append
# 첫 번째 데이터 제거 popleft()
# push, pop, size, empty, front, back
for _ in range(n):
    com = stdin.readline().split()
    if com[0] == 'push':
        q.append(int(com[1]))
    elif com[0] == 'pop':
        if q:
            print(q.popleft())
        else:
            print(-1)
    elif com[0] == 'size':
        print(len(q))
    elif com[0] == 'empty':
        if len(q) == 0:
            print(1)
        else:
            print(0)
    elif com[0] == 'back':
        if len(q) == 0:
            print(-1)
        else:
            print(q[-1])
    elif com[0] == 'front':
        if len(q) == 0:
            print(-1)
        else:
            print(q[0])
