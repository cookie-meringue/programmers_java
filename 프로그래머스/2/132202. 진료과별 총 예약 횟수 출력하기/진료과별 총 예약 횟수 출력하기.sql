-- 2022년 5월에 예약한 사람
-- MCDP_CD 별로 조회
-- MCDP_CD 별로 예약한 환자 수 기준 오름차순 정렬
-- MCDP_CD, 5월에 예약한 사람 수
SELECT a.MCDP_CD AS 진료과코드, COUNT(*) AS 5월예약건수
FROM APPOINTMENT a
WHERE DATE_FORMAT(a.APNT_YMD, '%Y-%m') = '2022-05'
GROUP BY a.MCDP_CD
ORDER BY 5월예약건수, 진료과코드;



# (
#     SELECT count(*) 
#     FROM APPOINTMENT temp 
#     WHERE DATE_FORMAT(temp.APNT_YMD, '%Y-%m') = '2022-05'
# ) 