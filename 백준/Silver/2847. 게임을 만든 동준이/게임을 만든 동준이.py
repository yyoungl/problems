n = int(input())
level = []
cnt = 0
for i in range(n):
    level.append(int(input()))

for i in range(1, n):
    if level[-i] <= level[-i-1]:
        cnt += level[-i-1] - level[-i] + 1
        level[-i-1] = level[-i] - 1

print(cnt)