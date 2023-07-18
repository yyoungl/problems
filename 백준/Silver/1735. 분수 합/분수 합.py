import math
a, b = map(int, input().split())
c, d = map(int, input().split())

bunja = a*d + b*c
bunmo = b*d

gcd = math.gcd(bunja, bunmo)
print(int(bunja/gcd), int(bunmo/gcd))