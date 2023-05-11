def solution(nums):
    N = len(nums)
    get = []
    for i in range(N):
        if nums[i] not in get and len(get) < N//2:
            get.append(nums[i])
        if len(get) == N//2:
            break
    return len(get)