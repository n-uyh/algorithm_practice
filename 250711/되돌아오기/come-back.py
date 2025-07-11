N = int(input())
moves = [tuple(input().split()) for _ in range(N)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]

directions = 'EWSN'
dxy = [(0,1),(0,-1),(1,0),(-1,0)]

x = 0
y = 0
time = 0
for i in range(N):
    direction = dir[i]

    for _ in range(dist[i]):
        time += 1
        d = directions.find(direction)
        x += dxy[d][0]
        y += dxy[d][1]

        if (x == 0 and y == 0):
            print(time)
            exit()

print(-1)