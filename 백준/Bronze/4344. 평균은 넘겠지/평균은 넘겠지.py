case = int(input())
for _ in range(case):
    score = input().split()
    score = list(map(int, score))
    N = score[0]
    avg = sum(score[1:]) / N
    result = sum(1 for s in score[1:] if s > avg)
    print(f"{round(100*result/N, 3):.3f}%")