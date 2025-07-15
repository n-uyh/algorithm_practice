from collections import deque

queue = deque()

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

dxy = [(-1,0),(1,0),(0,-1),(0,1)]

visited = [
    [0 for _ in range(n)] for _ in range(n)
]
dist = [
    [-1 for _ in range(n)] for _ in range(n)
]

def in_range(x, y):
    return 0 <= x < n and 0 <= y < n

def bfs():
    while queue:
        x,y = queue.popleft()

        for i in range(4):
            nx = x + dxy[i][0]
            ny = y + dxy[i][1]
            if (in_range(nx,ny) and visited[nx][ny] == 0):
                visited[nx][ny] = 1
                if (grid[nx][ny] == 1):
                    dist[nx][ny] = dist[x][y] + 1
                    queue.append((nx,ny))
            



def main():
    visited[0][0] = 1
    dist[0][0] = 0
    queue.append((0,0))
    bfs()
    print(dist[n-1][n-1])

main()