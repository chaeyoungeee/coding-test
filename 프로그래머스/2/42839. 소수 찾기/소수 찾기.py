from itertools import permutations

def is_prime(k):
    if k == 0 or k == 1: return False
    for i in range(2, int(k**0.5)+1):
        if k % i == 0: return False
    return True

def solution(numbers):
    s = set()
    n = list(numbers)
    primes = set()
    
    for i in range(1, len(numbers)+1):
        s.update(set(permutations(n, i)))
        
    for i in s:
        n = int(''.join(i))
        if is_prime(n):
            primes.add(n)
    
    return len(primes)