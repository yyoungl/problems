paper = [[0]*101 for _ in range(101)]
answer = 0
N = int(input())

for _ in range(N):
    c, r = map(int, input().split())
    for i in range(10):
        for j in range(10):
            if c+i < 101 and c+i >=0 and r+j >= 0 and r+j < 101:
                paper[c+i][r+j] = 1

for i in range(101):
    answer += paper[i].count(1)


print(answer)