n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]

s = 0

sortedA = sorted(a, reverse=True)
sortedB = sorted(b)

for x in range(n):
    s += sortedA[x] * sortedB[x]

print(s)