N, K = map(int, input().split())
coins = []
answer = 0

for _ in range(N):
    coins.append(int(input()))

coins = sorted(coins, reverse = True)

for coin in coins:
    answer += K // coin
    K %= coin

print(answer)