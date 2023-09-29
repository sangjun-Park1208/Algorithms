# Select
#     MCDP_CD 진료과코드, 
#     Count(*) 5월예약건수
# From APPOINTMENT 
# Where DATE_FORMAT(APNT_YMD, '%Y-%m')='2022-05'
# Group by MCDP_CD
# Order by Count(*), MCDP_CD


select MCDP_CD as 진료과코드, count(*) as 5월예약건수
from APPOINTMENT
where date_format(APNT_YMD, '%Y-%m')='2022-05'
group by MCDP_CD
order by 5월예약건수, 진료과코드