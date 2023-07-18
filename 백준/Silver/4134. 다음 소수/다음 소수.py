N = int(input())


def is_prime(n):
    if n == 0 or n ==1:
        return False
    for k in range(2, int(n ** 0.5) + 1):
        if n % k == 0:
            return False
    return True


for _ in range(N):
    num = int(input())
    while True:
        if num==0 or num==1:
            print(2)
            break
        if is_prime(num):
            print(num)
            break
        else:
            num+=1