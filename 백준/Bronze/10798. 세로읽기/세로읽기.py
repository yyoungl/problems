letter = []

for _ in range(5):
    letter.append(list(input()))

length = []
for i in range(5):
    length.append(len(letter[i]))

for i in range(max(length)):
    for j in range(5):
        if i < len(letter[j]):
            print(letter[j][i], end="")