Select
    MCDP_CD 진료과코드, 
    Count(MCDP_CD) 5월예약건수
From APPOINTMENT 
Where DATE_FORMAT(APNT_YMD, '%Y-%m')='2022-05'
Group by MCDP_CD
Order by Count(MCDP_CD), MCDP_CD