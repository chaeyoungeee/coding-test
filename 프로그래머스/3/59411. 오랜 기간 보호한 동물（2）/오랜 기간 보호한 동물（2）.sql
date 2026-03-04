# select i.ANIMAL_ID, i.NAME
# from ANIMAL_INS i
# join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
# order by o.DATETIME - i.DATETIME desc
# limit 2

with temp as (
select i.ANIMAL_ID, row_number() over(order by o.DATETIME - i.DATETIME desc) r
from ANIMAL_INS i
join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID)

select i.ANIMAL_ID, i.NAME
from ANIMAL_INS i
join temp t on t.ANIMAL_ID = i.ANIMAL_ID
where t.r <= 2