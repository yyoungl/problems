n = int(input())
table = [1] * 117
table[1] = 1
table[2] = 1
table[3] = 1
# 이거 table[1], table[2], table[3] = 1 이렇게 선언해도 되나?
if n > 3:
    for x in range(4, n+1):
        table[x] = table[x-1] + table[x-3]

print(table[n])