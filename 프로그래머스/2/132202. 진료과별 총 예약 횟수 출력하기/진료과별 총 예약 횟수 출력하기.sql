# select MCDP_CD '진료과코드', count(1) '5월예약건수'
# from APPOINTMENT
# where APNT_YMD >= '2022-05-01' and APNT_YMD < '2022-06-01'
# group by MCDP_CD
# order by '5월예약건수', '진료과코드'

SELECT MCDP_CD AS '진료과 코드', COUNT(1) AS '5월예약건수'

FROM APPOINTMENT

WHERE MONTH(APNT_YMD) = '5'

GROUP BY MCDP_CD

ORDER BY COUNT(1), MCDP_CD;

