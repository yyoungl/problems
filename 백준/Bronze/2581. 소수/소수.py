M = int(input())
N = int(input())
primes = []
for num in range(M, N+1):

    if num < 2:
        continue
    is_prime = True
    for i in range(2, int(num**0.5+1)):
        if num % i == 0:
            is_prime = False
            break
    if is_prime:
        primes.append(num)

if primes:
    print(sum(primes))
    print(primes[0])
else:
    print(-1)