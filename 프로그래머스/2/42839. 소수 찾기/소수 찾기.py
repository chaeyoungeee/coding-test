data = set()

def is_prime(k):
    if k == 0 or k == 1: return False
    for i in range(2, int(k**0.5)+1):
        if k % i == 0: return False
    return True

def perm(i, n, visited, numbers):
    if len(i) == n:
        p = int(i)
        if is_prime(p):
            data.add(p)
        return

    for j in range(len(numbers)):
        if not visited[j]:
            visited[j] = True
            perm(i+numbers[j], n, visited, numbers)
            visited[j] = False

def solution(numbers):
    n = list(numbers)
    primes = set()
        
    l = len(numbers)
    for i in range(1, 1+l):
        perm("", i, [False]*l, numbers)
                   
    return len(data)