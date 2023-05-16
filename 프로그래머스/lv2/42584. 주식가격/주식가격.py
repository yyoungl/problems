# from collections import deque
# def solution(prices):
#     answer = []
    
#     prices = deque(prices)
#     while prices:
#         c = prices.popleft()
#         count = 0
#         for x in prices:
#             if c > x:
                
        
#     return answer
# from collections import deque
# def solution(prices):       # 코드를 해석해보자면 prices를 큐로 만들고
#     answer = []             # 첫번째 원소를 popleft()로 제거하고 남은 prices와 가격비교
#     prices = deque(prices)  # 더 작은 가격을 찾으면 탈출
#     while prices:
#         c = prices.popleft()

#         count = 0
#         for i in prices:
#             if c > i:
#                 count += 1
#                 break
#             count += 1

#         answer.append(count)

#     return answer

def solution(prices):
    n = len(prices)
    answer = [0] * n

    for i in range(n - 1):
        for j in range(i + 1, n):
            if prices[j] < prices[i]:
                answer[i] += 1
                break
            else:
                answer[i] += 1

    return answer
