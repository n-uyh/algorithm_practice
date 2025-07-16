from collections import deque
n, k = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# 상한귤부터 시작하는 bfs
visited = [[-1]*n for _ in range (n)]

dx = [0,1,0,-1]
dy = [1,0,-1,0]
queue = deque()

def printVisited():
    for r in visited:
        print(' '.join(map(str,r)))

    # print()
    # for r in grid:
    #     print(' '.join(map(str,r)))

def in_range(x,y):
    return 0 <= x < n and 0 <= y < n

def bfs():
    while queue:
        x,y = queue.popleft()
        # print(x,y)
        # printVisited()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (in_range(nx,ny) and visited[nx][ny] == -1 and grid[nx][ny] == 1):
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx,ny))

def main():
    # 시작점 - 상한귤 queue에 넣기
    for i in range(n):
        for j in range(n):
            if (grid[i][j] == 2):
                queue.append((i,j))
                visited[i][j] = 0

    bfs()

    for i in range(n):
        for j in range(n):
            if (visited[i][j] == -1 and grid[i][j] == 1):
                visited[i][j] = -2

    printVisited()

main()