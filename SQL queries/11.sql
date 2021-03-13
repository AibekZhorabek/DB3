SELECT u_surname,u_name,mc_name,urm_buildingRating,urm_equipmentRating,urm_attitudeRating,urm_comfortRating,urm_punctualityRating,urm_pros,urm_cons,urm_info  
FROM user_review_medcenter
INNER JOIN user
ON urm_userId=u_id
INNER JOIN medical_center
ON urm_medCenterId=mc_id
INNER JOIN status
ON urm_statusId=s_id
WHERE s_name='running'
AND urm_medCenterId=1;