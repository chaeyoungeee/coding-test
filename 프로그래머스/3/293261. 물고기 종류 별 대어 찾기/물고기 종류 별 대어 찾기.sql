select fi.ID, fni.FISH_NAME, fi.LENGTH
from FISH_INFO fi
left join FISH_NAME_INFO fni on fi.FISH_TYPE = fni.FISH_TYPE
where (fi.FISH_TYPE, fi.LENGTH) in (select f.FISH_TYPE, max(f.LENGTH)
    from FISH_INFO f
    group by f.FISH_TYPE)
order by fi.ID