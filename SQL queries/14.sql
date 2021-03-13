SELECT d_surname,d_name,pr_name,dwh_numOfDay,dwh_time,at_name,dmc_price 
FROM doctor_working_hour
INNER JOIN doctor_medical_center
ON dwh_doctorMedCenterId=dmc_id
INNER JOIN doctor
ON dwh_doctorId=d_id
INNER JOIN profession
ON dmc_professionId=pr_id
INNER JOIN appointment_type
ON dmc_appointmentTypeId=at_id
INNER JOIN medical_center
ON dmc_medCenterId=mc_id
INNER JOIN status 
ON dwh_statusId=s_id
WHERE s_name='running'
AND dwh_doctorId=1;