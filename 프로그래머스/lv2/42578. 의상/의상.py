def solution(clothes):
    answer = 1
    hash = {}
    for Name, Type in clothes:
        hash[Type] = hash.get(Type, 0) + 1

    for Type in hash:
        answer *= (hash[Type] +1)
        
    return answer-1