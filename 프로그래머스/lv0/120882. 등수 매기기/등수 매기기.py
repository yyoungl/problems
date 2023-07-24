def solution(score):
    N = len(score)
    rank = [1] * N
    sums = []
    for x in score:
        sums.append(x[0]+x[1])

    for i in range(N):
        for j in range(0, i):
            if sums[j] > sums[i]:
                rank[i]+=1
        for j in range(i+1, N):
            if sums[j] > sums[i]:
                rank[i]+=1
    return rank
