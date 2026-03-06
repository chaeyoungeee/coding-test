select e1.ID, count(e2.ID) CHILD_COUNT
from ECOLI_DATA e1
left join ECOLI_DATA e2 on e1.ID = e2.PARENT_ID
group by ID
order by 1