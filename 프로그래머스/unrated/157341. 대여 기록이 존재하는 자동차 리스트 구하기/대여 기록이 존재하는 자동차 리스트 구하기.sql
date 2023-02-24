-- 코드를 입력하세요
Select Distinct(C.CAR_ID)
From CAR_RENTAL_COMPANY_CAR C
    Join CAR_RENTAL_COMPANY_RENTAL_HISTORY R
    On C.CAR_ID=R.CAR_ID
Where CAR_TYPE='세단' And Month(START_DATE)=10
Order by C.CAR_ID desc

