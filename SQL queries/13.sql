SELECT d_surname,d_name,d_phone,d_gender,d_briefInfo,d_experience 
FROM doctor
INNER JOIN status
ON d_statusId=s_id
WHERE s_name='running'
AND d_id=1;

SELECT d_surname,d_name,djh_startedYear,djh_finishedYear,djh_placeName 
FROM doctor_job_history
INNER JOIN doctor
ON djh_doctorId=d_id
INNER JOIN status
ON d_statusId=s_id
WHERE s_name='running'
AND djh_doctorId=1;

SELECT d_surname,d_name,deh_year,deh_placeName
FROM doctor_education_history
INNER JOIN doctor
ON deh_doctorId=d_id
INNER JOIN status
ON d_statusId=s_id
WHERE s_name='running'
AND deh_doctorId=1;




