with temp as (
    select BOARD_ID
    from USED_GOODS_BOARD
    order by VIEWS desc
    limit 1
)

select concat('/home/grep/src/', BOARD_ID, '/', FILE_ID, FILE_NAME, FILE_EXT) FILE_PATH
from USED_GOODS_FILE f
where BOARD_ID in (
    select * from temp
)
order by FILE_ID desc