SELECT mc_name,mc_phone,mc_address,mc_briefInfo,mc_type,mc_info,cg_name 
FROM medical_center
INNER JOIN status
ON mc_statusId=s_id
INNER JOIN clinic_group
ON mc_clinicGroupId=cg_id
WHERE mc_cityId=1
AND s_name='running';