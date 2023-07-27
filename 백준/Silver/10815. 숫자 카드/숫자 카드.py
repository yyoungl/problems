N = int(input())
list_input = list(map(int, input().split()))
set_list = set(list_input)

M = int(input())
card = list(map(int, input().split()))
answer = [0] * M
for i in range(M):
    if card[i] in set_list:
        answer[i]+=1


for x in answer:
    print(x, end= " ")
