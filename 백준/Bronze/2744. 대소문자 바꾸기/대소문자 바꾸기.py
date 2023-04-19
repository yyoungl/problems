string = input()
answer = []

for s in string:
    if s.isupper():
        answer.append(s.lower())
    else:
        answer.append(s.upper())

print(''.join(str(x) for x in answer))