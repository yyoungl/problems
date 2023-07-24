def solution(dots):
    p1 = [dots[0][0], dots[0][1]]
    p2 = [dots[1][0], dots[1][1]]
    p3 = [dots[2][0], dots[2][1]]
    p4 = [dots[3][0], dots[3][1]]

    if slope(p1, p2) == slope(p3, p4):
        return 1
    elif slope(p1, p3) == slope(p2, p4):
        return 1
    elif slope(p1, p4) == slope(p2, p3):
        return 1

    return 0

def slope(A, B):
    return (A[1]-B[1]) / (A[0]-B[0])
