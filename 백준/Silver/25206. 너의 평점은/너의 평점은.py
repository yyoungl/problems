#백준 25206
grade = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0.0}
result = 0 #취득 학점 * 성적 점수
credit = 0 #취득 학점

for _ in range(20):
    score = input().split()
   
    # score [과목 이름, 취득 학점, 성적]
    if score[2] != 'P':
        credit += float(score[1])
        result += float(score[1]) * grade[score[2]]

print(result/credit)