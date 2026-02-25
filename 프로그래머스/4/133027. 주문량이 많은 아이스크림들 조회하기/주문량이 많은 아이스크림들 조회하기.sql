select a.FLAVOR FLAVOR
from (select FLAVOR, TOTAL_ORDER
        from FIRST_HALF f

        union all

        select FLAVOR, TOTAL_ORDER
        from JULY) a
        
group by FLAVOR
order by sum(TOTAL_ORDER) desc
limit 3