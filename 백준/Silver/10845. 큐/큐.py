from sys import stdin

queue = []
n = int(stdin.readline())

for _ in range(n):
    com = stdin.readline().split()
    if com[0] == 'push': queue.append(int(com[1]))
    elif com[0] == 'pop':
        if queue:
            print(queue.pop(0))
        else:
            print(-1)
    elif com[0] == 'size': print(len(queue))
    elif com[0] == 'empty':
        if len(queue) == 0 : print(1)
        else: print(0)
            
    elif com[0] == 'front':
        if len(queue) == 0 : print(-1)
        else: print(queue[0])
    elif com[0] == 'back':
        if len(queue) == 0 : print(-1)
        else: print(queue[-1])