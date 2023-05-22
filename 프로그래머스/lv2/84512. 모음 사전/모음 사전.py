from itertools import product
def solution(word):
    answer = 0
    words = []
    for i in range(1, 6):
        for c in product(['A', 'E', 'I', 'O', 'U'], repeat=i):
            words.append(''.join(list(c)))
    words.sort()
    return words.index(word) + 1