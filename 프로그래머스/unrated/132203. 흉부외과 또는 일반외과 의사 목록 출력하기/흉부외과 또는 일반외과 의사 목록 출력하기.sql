Select DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d')
From DOCTOR 
Where MCDP_CD='CS' Or MCDP_CD='GS'
Order by HIRE_YMD Desc, DR_NAME