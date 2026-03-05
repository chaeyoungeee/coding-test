select t.ITEM_ID, ITEM_NAME
from ITEM_TREE t
join ITEM_INFO i using(ITEM_ID)
where PARENT_ITEM_ID is null
order by 1