def solution(board):
    n = len(board)
    cnt = n*n
    dr = [-1, 0, 1, -1, 1, -1, 0, 1]
    dc = [-1, -1, -1, 0, 0, 1, 1, 1]
    answer = [[0]*n for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                answer[i][j] = 1
                for d in range(8):
                    r = i+dr[d]
                    c = j+dc[d]
                    if (r >=0 and r<n and c>=0 and c<n) :
                        answer[r][c] = 1

    for i in range(n):
        cnt -= answer[i].count(1)
    return cnt