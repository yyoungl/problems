while True:
    a, b, c = map(int, input().split())
    is_triangle = (a + b > c and b + c > a and c + a > b)
    if a == 0 or b == 0 or c == 0:
        break
    elif not is_triangle:
        print("Invalid")
    elif a == b and b == c and c == a:
        print("Equilateral")
    elif a == b or b == c or c == a:
        print("Isosceles")
    else:
        print("Scalene")