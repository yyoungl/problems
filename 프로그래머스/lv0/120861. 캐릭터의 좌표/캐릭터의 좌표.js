function solution(keyinput, board) {
    var answer = [0, 0];
    for (var i of keyinput) {
        if (i == "left" && answer[0] > - (board[0]-1)/2){
            answer[0] -= 1;
        }
        else if (i == "right" && answer[0] < (board[0]-1)/2) {
            answer[0] +=1;
        }
        else if (i == "up" && answer[1] < (board[1] -1 )/2 ) {
            answer[1] += 1;
                 }
        else if (i == "down" && answer[1] > -(board[1]-1)/2 ) {
            answer[1]-=1;
        }
    }
    return answer;
}
