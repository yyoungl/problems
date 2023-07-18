N = int(input())
cnt = 0
trees = []
distances = []
for _ in range(N):
    trees.append(int(input()))

for i in range(N - 1):
    distances.append(trees[i + 1] - trees[i])
# print("나무 간격:", distances)
distances = list(set(distances))
# print("나무 간격 중복 제거:", distances)


def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


distance_gcd = distances[0]

for i in range(len(distances)):
    distance_gcd = gcd(distances[i], distance_gcd)

# print("거리 최대공약수:", distance_gcd)
for i in range(N - 1):
    distance = trees[i + 1] - trees[i]
    if distance != distance_gcd:
        cnt += distance // distance_gcd - 1

print(cnt)
