def solution(phone_book):
    n = len(phone_book)
    phone_book.sort()
    
    for i in range(1, n):
        if phone_book[i].startswith(phone_book[i-1]):
            return False
        
    return True