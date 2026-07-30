from pprint import pprint

def solution(land):
    answer = 0
    dirs = ((0, 1), (0, -1), (1, 0), (-1, 0))
    def dfs(x, y, c):
        visited[x][y] = c
        for d in dirs:
            nx = x + d[0]
            ny = y + d[1]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= m: continue
            if not land[nx][ny]: continue
            if visited[nx][ny]: continue
            
            visited[nx][ny] = dfs(nx, ny, c+1)
        return c
    
    n = len(land)
    m = len(land[0])
    visited = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1:
                dfs(i, j, 1)
                
                pprint(visited)
                print()
        
    return answer