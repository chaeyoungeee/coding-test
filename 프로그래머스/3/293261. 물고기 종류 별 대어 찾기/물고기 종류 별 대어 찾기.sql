with rnk as (select ID, FISH_TYPE, LENGTH,
        rank() over(partition by FISH_TYPE order by LENGTH desc) r
from FISH_INFO
)

select ID, FISH_NAME, LENGTH
from rnk r
join FISH_NAME_INFO n on r.FISH_TYPE = n.FISH_TYPE
where r = 1
order by 1