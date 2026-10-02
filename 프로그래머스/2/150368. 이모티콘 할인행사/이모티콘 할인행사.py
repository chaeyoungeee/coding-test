from itertools import product

def solution(users, emoticons):  
    m = len(emoticons)
    pd = list(product([10, 20, 30, 40], repeat=m))
    result = [0, 0]
    
    for ratios in pd:
        mms = 0
        total = 0
        if len(users) == 2:
            print(ratios)
        for user in users:
            price = 0
            for i in range(m):
                if user[0] <= ratios[i]:
                    price += emoticons[i] * (100-ratios[i])//100
                    if price >= user[1]:
                        mms += 1
                        price = 0
                        break
            total += price

        if mms > result[0]:
            result = [mms, total]
        elif mms == result[0] and total > result[1]:
            result = [mms, total]
                    
    return result