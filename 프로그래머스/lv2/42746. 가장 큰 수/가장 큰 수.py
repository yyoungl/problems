def solution(numbers):
    numbers = list(map(str, numbers))
    
    # 숫자를 정렬하는 기준을 변경하여 정렬
    numbers.sort(key=lambda x: x*3, reverse=True)
    
    # 리스트의 숫자들을 이어붙여서 문자열로 반환
    answer = ''.join(numbers)
    
    # answer가 0으로 시작하는 경우를 처리하기 위해 int로 변환 후 다시 문자열로 변환
    return str(int(answer))