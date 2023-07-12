N, M = map(int, input().split())
baskets = [i for i in range(1, N+1)]
# print(baskets, "처음")
for _ in range(M):
    i, j = map(int, input().split())
    new = list(reversed(baskets[i-1:j]))
    # print(new)
    baskets[i-1:j] = new

baskets = [str(i) for i in baskets]

print(*baskets)