SELECT MCDP_CD 진료과코드, count(*) 5월예약건수
FROM appointment
WHERE APNT_YMD >= '2022-05-01'
AND APNT_YMD <= '2022-05-31'
GROUP BY MCDP_CD   
ORDER BY 5월예약건수, 진료과코드