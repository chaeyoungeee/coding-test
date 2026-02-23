select distinct o1.USER_ID, o1.PRODUCT_ID
from ONLINE_SALE o1
inner join ONLINE_SALE o2
on (o1.ONLINE_SALE_ID != o2.ONLINE_SALE_ID 
    and o1.PRODUCT_ID = o2.PRODUCT_ID
    and o1.USER_ID = o2.USER_ID)
order by o1.USER_ID asc, o1.PRODUCT_ID desc