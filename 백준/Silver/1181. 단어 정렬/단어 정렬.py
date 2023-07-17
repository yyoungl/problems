N = int(input())
words = []
for _ in range(N):
    words.append(input())
set_words = set(words)
words = list(set_words)
words.sort()
words.sort(key = len)

for word in words:
    print(word)