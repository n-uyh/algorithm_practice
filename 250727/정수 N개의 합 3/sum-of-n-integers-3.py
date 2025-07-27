n, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

target = [[0, 0, 0, 0]]

for row in arr:
    target.append([0] + row)

ps = [[0] * (n+1) for _ in range(n+1)]

# 누적합
for i in range(1,n+1):
    for j in range(1,n+1):
        ps[i][j] = ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1] + target[i][j]

max_sum = target[1][1]

# 부분합
for i in range(1,n-k+2):
    for j in range(1,n-k+2):
        part_sum = ps[i+k-1][j+k-1] - ps[i-1][j+k-1] - ps[i+k-1][j-1] + ps[i-1][j-1]
        if part_sum > max_sum:
            max_sum = part_sum

print(max_sum)