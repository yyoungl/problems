import sys
N, M = map(int, sys.stdin.readline().split())
dict1 = {}
dict2 = {}
for i in range(1, N+1):
    k = sys.stdin.readline().strip()
    dict1[i] = k
    dict2[k] = i

for i in range(M):
    pro = sys.stdin.readline().strip()
    if pro.isdigit():
        print(dict1[int(pro)])
    else:
        print(dict2[pro])