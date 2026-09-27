from collections import deque

def solution(maps):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    n, m = len(maps), len(maps[0])
    visited = [[-1] * m for _ in range(n) ]
    
    que = deque([(0, 0)])
    visited[0][0] = 1

    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            
            if nx < 0 or nx >= n or ny < 0 or ny >= m: continue
            if not maps[nx][ny]: continue
            if visited[nx][ny] != -1: continue
            
            visited[nx][ny] = visited[x][y] + 1
            que.append((nx, ny))
            
    return visited[n-1][m-1]
 