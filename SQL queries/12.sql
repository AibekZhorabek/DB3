SELECT u_surname,u_name,d_surname,d_name,urd_carefulnessRating,urd_efficiencyRating,urd_attitudeRating,urd_informingRating,urd_willAdviseRating,urd_info,urd_pros,urd_cons
FROM user_review_doctor
INNER JOIN user
ON urd_userId=u_id
INNER JOIN doctor
ON urd_doctorId=d_id
INNER JOIN medical_center
ON urd_medCenterId=mc_id
INNER JOIN status
ON urd_statusId=s_id
WHERE s_name='running'
AND urd_doctorId=1;