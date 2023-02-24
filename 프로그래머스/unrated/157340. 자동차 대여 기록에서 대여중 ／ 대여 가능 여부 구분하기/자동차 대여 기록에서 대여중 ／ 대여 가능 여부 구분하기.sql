Select 
    CAR_ID,
    (Case
        When CAR_ID In(
        Select CAR_ID
        From CAR_RENTAL_COMPANY_RENTAL_HISTORY
        Where '2022-10-16'
        Between START_DATE And END_DATE)
        Then '대여중'
        Else '대여 가능'
        End
    )
    As AVAILABILITY
From CAR_RENTAL_COMPANY_RENTAL_HISTORY 
Group by CAR_ID
Order by CAR_ID desc