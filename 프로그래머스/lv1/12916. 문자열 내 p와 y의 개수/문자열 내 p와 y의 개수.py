def solution(s):
    answer = True
    if s.count('p') + s.count('P') != s.count('y') + s.count('Y'):
        return False
    else: 
        return True