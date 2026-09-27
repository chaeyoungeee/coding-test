def dfs(i, n, visited, computers):
    visited[i] = 1
    for j in range(n):
        if computers[i][j] and not visited[j]:
            dfs(j, n, visited, computers)
        

def solution(n, computers):
    visited = [0] * n
    cnt = 0
    
    for i in range(n):
        if not visited[i]:
            cnt += 1
            dfs(i, n, visited, computers)

    return cnt