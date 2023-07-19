N = int(input())
members = {}
for _ in range(N):
    log = input().split()
    if log[1] == 'enter':
        members[log[0]] = 'enter'
    else:
        if members[log[0]]:
            del members[log[0]]
members = sorted(members, reverse=True)
for member in members:
    print(member)