with recursive hours as (
    select 0 h
    union all
    select h + 1 from hours where h < 23
)

select h HOUR, count(ANIMAL_ID) COUNT
from hours a 
left join ANIMAL_OUTS b on a.h = hour(b.DATETIME)
group by h
order by h