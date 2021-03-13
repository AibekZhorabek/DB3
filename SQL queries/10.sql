SELECT d_surname,d_name,pr_name,mc_name,at_name
FROM doctor_medical_center
INNER JOIN doctor
ON dmc_doctorId=d_id
INNER JOIN medical_center
ON dmc_medCenterId=mc_id
INNER JOIN profession
ON dmc_professionId=pr_id
INNER JOIN status
ON dmc_statusId=s_id
INNER JOIN appointment_type
ON dmc_appointmentTypeId=at_id
WHERE s_name='running'
AND dmc_medCenterId=1;