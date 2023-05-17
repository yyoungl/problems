import heapq

def solution(scoville, K):
    answer = 0
    scoville = sorted(scoville)
    while any(sco < K for sco in scoville):
        if len(scoville) < 2:
            return -1
        
        heapq.heappush(scoville, heapq.heappop(scoville) + heapq.heappop(scoville)*2)
        answer += 1
        
    return answer