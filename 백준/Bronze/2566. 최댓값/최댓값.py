array = []

for _ in range(9):
    array.append(list(map(int, input().split())))

maxNum = -1
r, c = 0, 0
for i in range(9):
    for j in range(9):
        if array[i][j] > maxNum:
            maxNum = array[i][j]
            r = i+1
            c = j+1

print(maxNum)
print(r, c)