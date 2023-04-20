N = int(input())
schedule = []
for _ in range(N):
    schedule.append(list(map(int, input().split())))

answer = [0] * (N+1)

for i in range(N):
    for j in range(i+schedule[i][0], N+1):
        if answer[j] < answer[i] + schedule[i][1]:
            answer[j] = answer[i] + schedule[i][1]
            
print(answer[-1])