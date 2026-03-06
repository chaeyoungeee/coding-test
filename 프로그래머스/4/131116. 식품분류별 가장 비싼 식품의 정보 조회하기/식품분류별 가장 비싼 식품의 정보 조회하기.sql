with rnk as (
    select CATEGORY, PRICE, PRODUCT_NAME,
        rank() over(partition by CATEGORY order by PRICE desc) r
    from FOOD_PRODUCT
    where CATEGORY in ('과자', '국', '김치', '식용유')
)

select CATEGORY, PRICE, PRODUCT_NAME
from rnk
where r = 1
order by 2 desc