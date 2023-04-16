N = int(input())

for i in range(1, N+1):
    digits_sum = i + sum(map(int, str(i)))
    if digits_sum == N:
        print(i)
        break
else:
    print(0)
