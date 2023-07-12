#백준 1316
N = int(input())
cnt = N
for _ in range(N):
    string = input()
    for i in range(0, len(string)-1):
        if string[i] == string[i+1]:
            pass
        elif string[i] in string[i+1:]:
            cnt-=1
            break
            
print(cnt)