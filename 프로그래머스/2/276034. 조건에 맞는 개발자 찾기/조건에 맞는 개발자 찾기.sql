select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d
join SKILLCODES s on d.SKILL_CODE & s.CODE != 0
where NAME in ('Python', 'C#')
order by 1