SELECT mc_name,cg_name 
FROM `clinic_group`
INNER JOIN medical_center
ON cg_id=mc_clinicGroupId
INNER JOIN status
ON mc_statusId=s_id
WHERE cg_id=1 AND s_name='running';