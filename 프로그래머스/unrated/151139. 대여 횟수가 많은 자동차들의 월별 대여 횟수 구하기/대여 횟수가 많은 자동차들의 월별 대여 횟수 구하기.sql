# Select 
#     Month(START_DATE) MONTH,
#     CAR_ID,
#     Count(HISTORY_ID) RECORDS
# From CAR_RENTAL_COMPANY_RENTAL_HISTORY
# Where CAR_ID In(
#         Select CAR_ID
#         From CAR_RENTAL_COMPANY_RENTAL_HISTORY
#         Where START_DATE Between '2022-08-01' And '2022-10-31'
#         Group by CAR_ID
#         Having Count(CAR_ID)>=5
#     ) And START_DATE Between '2022-08-01' And '2022-10-31'
# Group by MONTH, CAR_ID
# Having RECORDS>0
# Order by MONTH, CAR_ID Desc

Select Month(START_DATE) MONTH, CAR_ID, Count(CAR_ID) RECORDS
    From CAR_RENTAL_COMPANY_RENTAL_HISTORY
    Where CAR_ID In (
        Select CAR_ID
        From CAR_RENTAL_COMPANY_RENTAL_HISTORY
        Where START_DATE Between '2022-08-01' And '2022-10-31'
        Group by CAR_ID
        Having Count(CAR_ID) >= 5
    ) And (START_DATE Between '2022-08-01' And '2022-10-31')
    Group by MONTH, CAR_ID
    Having RECORDS > 0
    Order by MONTH, CAR_ID Desc