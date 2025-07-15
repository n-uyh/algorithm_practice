from collections import deque
n, h, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

# for bfs
starts = []
dx = [0,1,0,-1]
dy = [1,0,-1,0]

# result
result = [[0] * n for _ in range(n)]

def printResult():
    for r in result:
        print(' '.join(map(str,r)))

def in_range(x,y):
    return 0 <= x < n and 0 <= y < n

def bfs(queue,visited):
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (in_range(nx,ny) and visited[nx][ny] == -1 and grid[nx][ny] != 1):
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx,ny))

                if (grid[nx][ny] == 3):
                    return visited[nx][ny]
    
    # 탐색을 마쳐도 비피할 곳을 못찾은 경우
    return -1

def main():
    # 탐색
    for i in range(n):
        for j in range(n):
            # 사람인 경우
            if (grid[i][j] == 2):
                visited = [[-1] * n for _ in range(n)]
                queue = deque()
                queue.append((i,j))
                visited[i][j] = 0
                result[i][j] = bfs(queue,visited)

# 실행
main()
printResult()


