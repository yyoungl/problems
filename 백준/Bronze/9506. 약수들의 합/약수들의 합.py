while True:
    N = int(input())
    if N == -1:
        break
    else:
        factors = []
        for i in range(1, N):
            if N % i == 0:
                factors.append(i)
        if N == sum(factors):

            factors = [str(x) for x in factors]
            print(N, '=', end=' ')
            print(' + '.join(factors))
        else:
            print(N, 'is NOT perfect.')
