N, M = map(int, input().split())
primes = []
def is_prime(n):
    if n == 0 or n ==1:
        return False
    for k in range(2, int(n ** 0.5) + 1):
        if n % k == 0:
            return False
    return True

for i in range(N, M+1):
    if is_prime(i):
        primes.append(i)
        
for i in primes:
    print(i)