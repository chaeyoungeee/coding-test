def dfs(numbers, target, idx, total):
    if idx == len(numbers):
        return 1 if target == total else 0

    return dfs(numbers, target, idx+1, total+numbers[idx]) + dfs(numbers, target, idx+1, total-numbers[idx])
    
def solution(numbers, target):
    return dfs(numbers, target, 0, 0)
