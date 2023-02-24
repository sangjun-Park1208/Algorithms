Select 
    PT_NAME, 
    PT_NO, 
    GEND_CD, 
    AGE, 
    (Case When TLNO IS NULL 
        Then 'NONE' 
        Else TLNO
        End)
    As TLNO
From PATIENT 
Where AGE<=12 And GEND_CD='W'
Order by AGE Desc, PT_NAME;