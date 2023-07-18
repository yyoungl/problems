a, b = map(int, input().split())
def gcd(a, b):
    while b>0:
        a, b = b, a%b
    return a

gcd = gcd(a, b)

print(a*b//gcd)