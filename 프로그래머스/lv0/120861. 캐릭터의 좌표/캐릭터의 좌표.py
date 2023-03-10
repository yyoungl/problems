def solution(keyinput, board):
    answer = [0, 0]
    
    
    for a in keyinput:
        if a == "left" and answer[0] > - (board[0]-1)/2 :
            answer[0] = answer[0] - 1
        elif a == "right" and answer[0] < (board[0]-1)/2 :
            answer[0] = answer[0] + 1
        elif a == "up" and answer[1] < (board[1]-1)/2 :
            answer[1] = answer[1] + 1
        elif a == "down" and answer[1] > - (board[1]-1)/2 :
            answer[1] = answer[1] - 1
    

    
    return answer