N, K = map(int, input().split())
sequence = []

# 리스트에 지목 순서 넣기
for i in range(N):
    sequence.append(int(input()))

# 처음 지목하는 사람은 게임을 제안한 0번
point = 0
# 카운트
cnt = 0

for i in range(N):
    point = sequence[point]
    cnt += 1
    if point == K:
        print(cnt)
        break
else:
    print(-1)