select ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO
where ITEM_ID in (select distinct i1.ITEM_ID
                    from ITEM_TREE i1
                    left join ITEM_TREE i2 on i1.ITEM_ID = i2.PARENT_ITEM_ID
                    where i2.ITEM_ID is null)
order by 1 desc