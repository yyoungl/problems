from itertools import permutations


def solution(numbers):
    permu = []
    numbers = list(numbers)
    answer = []
    for i in range(len(numbers)):
        perms = permutations(numbers, i+1)
        permu += [''.join(p) for p in perms]
    # print(permu)
    for perm in permu:
        x = int(perm)
        if x < 2:
            continue
        is_prime = True
        for i in range(2, int(x**0.5)+1):
            if x % i == 0:
                is_prime = False
        if is_prime:
            answer.append(x)
    
    return len(set(answer))