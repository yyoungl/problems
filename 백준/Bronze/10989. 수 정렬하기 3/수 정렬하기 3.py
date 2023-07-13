import sys
N = int(input())
lst = [0] * 10001
for _ in range(N):
    idx = int(sys.stdin.readline())
    lst[idx] += 1

for i in range(10001):
    if lst[i] != 0:
        for _ in range(lst[i]):
            print(i)