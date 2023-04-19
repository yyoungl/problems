change = 1000 - int(input())
coins = [500, 100, 50, 10, 5, 1]
answer = 0

for coin in coins:
    answer += change//coin
    change %= coin

print(answer)