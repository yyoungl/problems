n = int(input())
count = 0

while n>0:
    if n%5 == 0:
        count += n//5
        break
    elif n==1:
        count = -1
        break
	# 3킬로그램 봉지 +1
    else:
        n -= 2
        count += 1

print(count)