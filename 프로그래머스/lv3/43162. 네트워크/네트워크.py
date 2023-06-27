from collections import deque
def solution(n, computers):
    answer = 0
    start = 0
    visited = [False] * n
    graph = [[] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1 and i != j:
                graph[i].append(j)
    def dfs(start):
        q = [start]
        while q:
            node = q.pop()
            if not visited[node]:
                visited[node] = True
                q += graph[node]
            
    for i in range(n):
        if not visited[i]:
            dfs(i)
            answer+=1

    return answer

    