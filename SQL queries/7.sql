SELECT u_surname,u_name,m_name,ucm_info 
FROM user_comment_medicine
INNER JOIN user
ON ucm_userId=u_id
INNER JOIN medicine
ON ucm_medicineId=m_id
INNER JOIN status
ON ucm_statusId=s_id
WHERE s_name='running'
AND ucm_medicineId=1;