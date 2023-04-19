N = int(input())
numbers = []
number = 666

while len(numbers) < N:
    if '666' in str(number):
        numbers.append(number)
    number += 1

print(numbers[-1])