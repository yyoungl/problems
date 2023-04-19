N = int(input())
lines = [int(x) for x in input().split()]

lines = sorted(lines)
time = 0

for i in range(N):
    time += sum(lines[:i+1])

print(time)
