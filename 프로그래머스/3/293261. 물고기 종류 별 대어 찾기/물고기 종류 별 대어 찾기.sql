with big as (
    select FISH_TYPE, max(LENGTH) LENGTH
    from FISH_INFO
    group by FISH_TYPE
)

select ID, FISH_NAME, LENGTH
from FISH_INFO f
join FISH_NAME_INFO n on f.FISH_TYPE = n.FISH_TYPE
where (f.FISH_TYPE, f.LENGTH) in (select * from big)
order by ID