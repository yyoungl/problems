c = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
string = input()

for char in c:
    string=string.replace(char, '1')

print(len(string))