def solution(my_string):
    answer = 0
    for x in my_string:
        if x.isalpha():
            my_string = my_string.replace(x, ' ')
    my_string = my_string.split()
    return sum(list(map(int, my_string)))
