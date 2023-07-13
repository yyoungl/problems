a, b, c = map(int, input().split())
lengths = sorted([a, b, c])

while sum(lengths) - lengths[-1] <= lengths[-1]:
    lengths[-1] -= 1

print(sum(lengths))
