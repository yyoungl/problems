N = int(input())
for _ in range(N):
    a, b = map(int, input().split())
    A = min(a, b)
    B = max(a, b)
    for i in range(A, 0, -1):
        if B%i== 0 and A%i==0:
            gcd = i
            print(gcd * (A//gcd) * (B//gcd))
            break