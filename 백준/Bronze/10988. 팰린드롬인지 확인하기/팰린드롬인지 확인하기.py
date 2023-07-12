word = input()
N = len(word)
for i in range(N//2):
    if word[i] == word[-i-1]:
        continue
    else:
        print(0)
        break
    
else: print(1)