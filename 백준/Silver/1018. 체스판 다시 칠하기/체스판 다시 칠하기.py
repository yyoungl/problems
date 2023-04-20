N, M = map(int, input().split())
board = []
answer = []
for i in range(N) :
    board.append(list(input()))

# print(N, M, board)

for x in range(N-7):
    for y in range(M-7):
        black = 0
        white = 0
        
        for i in range(x, x+8):
            for j in range(y, y+8):
                if (i+j)%2 == 0:
                    if board[i][j] == 'W':
                        black += 1
                    else: #board[i][j] == 'B':#
                        white += 1
                else:
                    if board[i][j] == 'W':
                        white += 1
                    else: #board[i][j] == 'B':#
                        black += 1
         
        answer.append(black)
        answer.append(white)

print(min(answer))