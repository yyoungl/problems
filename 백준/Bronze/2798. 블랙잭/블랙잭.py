import itertools

n, limit = map(int, input().split())
arr = list(input().split(' '))
arr = [int(x) for x in arr]
comb = list(itertools.combinations(arr, 3))
blackjack = 0
for x in comb:
    if sum(x) > blackjack and sum(x) <= limit:
        blackjack = sum(x)

print(blackjack)
