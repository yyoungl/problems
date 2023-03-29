def solution(polynomial):
    answer = ''
    
    num = [0, 0]
    
    cal = polynomial.split(' ')
    for i in cal:
        if i == '+':
            cal.remove(i)
    
    for i in cal:
        if i == 'x':
            num[0] += 1
        elif i.isdigit():
            num[1] += int(i)
        else:
            num[0] += int(i[0:-1])
            
    if num[0] == 0:
        num[0] = str(num[0])
    elif num[0] == 1:
        num[0] = str(num[0])
        num[0] = 'x'
    else:
        num[0] = str(num[0])
        num[0] = num[0] + 'x'
    
    
            
    if num[0] == '0' and num[1] == 0:
        answer = '0'
    elif num[0] == '0':
        answer = str(num[1])
    elif num[1] == 0:
        answer = num[0]
    else:
        answer = num[0] + ' + ' + str(num[1])
        
        
    return answer