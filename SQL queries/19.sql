SELECT u_name,m_name,ucm_info,ucm_postDate
FROM `user_comment_medicine`
INNER JOIN user
ON ucm_userId=u_id
INNER JOIN medicine
ON ucm_medicineId=m_id
INNER JOIN status
ON ucm_statusId=s_id
WHERE s_name='running'
AND ucm_userId=1
AND ucm_medicineId=1;


SELECT u_name,d_name,urd_info,urd_pros,urd_cons,urd_carefulnessRating,urd_efficiencyRating,urd_attitudeRating,urd_attitudeRating,urd_informingRating,urd_willAdviseRating,urd_postDate 
FROM `user_review_doctor`
INNER JOIN user
ON urd_userId=u_id
INNER JOIN doctor
ON urd_doctorId=d_id
INNER JOIN status
ON urd_statusId=s_id
WHERE s_name='running'
AND urd_userId=1
AND urd_doctorId=1;


SELECT u_name,mc_name,`urm_info`,`urm_pros`,`urm_cons`,`urm_buildingRating`,`urm_equipmentRating`,`urm_attitudeRating`,`urm_comfortRating`,`urm_punctualityRating`,`urm_postDate` 
FROM `user_review_medcenter`
INNER JOIN user
ON urm_userId=u_id
INNER JOIN medical_center
ON urm_medCenterId=mc_id
INNER JOIN status
ON urm_statusId=s_id
WHERE s_name='running'
AND urm_userId=1
AND urm_medCenterId=1