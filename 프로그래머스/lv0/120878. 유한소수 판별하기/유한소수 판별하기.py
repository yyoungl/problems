

def solution(a, b):
    def gcd(a, b):
        while (b > 0):
            a, b = b, a % b
        return a
    gcd = gcd(a, b)
    a = a//gcd
    b = b//gcd
    N = b
    factors = []
    i=2
    while N != 1:
        if N%i == 0:
            N=N//i
            factors.append(i)
        else:
            i+=1

    factors = list(set(factors))
    if 2 in factors:
        factors.remove(2)
    if   5 in factors:
        factors.remove(5)
    if len(factors) == 0:
        return 1
    else:
        return 2
