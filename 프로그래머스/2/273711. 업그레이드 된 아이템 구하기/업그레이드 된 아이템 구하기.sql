select t2.ITEM_ID, i2.ITEM_NAME, i2.RARITY
from ITEM_INFO i1
join ITEM_TREE t2 on i1.ITEM_ID = t2.PARENT_ITEM_ID
join ITEM_INFO i2 on t2.ITEM_ID = i2.ITEM_ID
where i1.RARITY = 'RARE'
order by 1 desc