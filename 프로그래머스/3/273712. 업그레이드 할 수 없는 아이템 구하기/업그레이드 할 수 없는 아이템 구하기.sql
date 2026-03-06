select i.ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO i
left join ITEM_TREE t on i.ITEM_ID = t.PARENT_ITEM_ID
where t.ITEM_ID is null
order by 1 desc