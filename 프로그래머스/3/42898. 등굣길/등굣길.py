def solution(m, n, puddles):
    dir = {(0, 1), (1, 0)}
    maps = [[0]*n for _ in range(m)]
    maps[0][0] = 1
    
    for p in puddles:
        maps[p[0]-1][p[1]-1] = -1
    
    for i in range(m):
        for j in range(n):
            if maps[i][j] == -1: continue
            for d in dir:
                x, y = i+d[0], j+d[1]
                if x >= m or y >= n or maps[x][y] == -1: continue
                maps[x][y] += maps[i][j]
                maps[x][y] %= 1_000_000_007
    
    return maps[m-1][n-1]