-- 1. -------------------------------------------------------------------------
SELECT STUDENT_NO 학번, STUDENT_NAME 이름, TO_CHAR(ENTRANCE_DATE, 'YYYY-MM-DD') 입학년도
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY ENTRANCE_DATE;

-- 2. -------------------------------------------------------------------------
SELECT PROFESSOR_NAME , PROFESSOR_SSN 
FROM TB_PROFESSOR
WHERE LENGTH(PROFESSOR_NAME) <> 3;

-- 3. -------------------------------------------------------------------------
SELECT PROFESSOR_NAME 교수이름 , TRUNC(MONTHS_BETWEEN(SYSDATE, TO_DATE(19||SUBSTR(PROFESSOR_SSN, 0, 6), 'RRRRMMDD'))/12) 나이
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN , 8, 1) = '1'
ORDER BY 나이;

-- 4. -------------------------------------------------------------------------
SELECT SUBSTR(PROFESSOR_NAME, 2, 2) 이름
FROM TB_PROFESSOR;

-- 5. -------------------------------------------------------------------------
SELECT STUDENT_NO , STUDENT_NAME 
FROM TB_STUDENT
WHERE TO_NUMBER(TO_CHAR(ENTRANCE_DATE, 'RRRR'))-TO_NUMBER(19||SUBSTR(STUDENT_SSN, 0, 2))>19;

-- 6. -------------------------------------------------------------------------
SELECT TO_CHAR(TO_DATE('2020/12/25', 'YYYY/MM/DD'), 'DY' ) 요일 FROM DUAL;

-- 7. -------------------------------------------------------------------------
SELECT TO_DATE('99/10/11', 'YY/MM/DD'), TO_DATE('49/10/11', 'YY/MM/DD')
FROM DUAL;  -- Y는 현재 세기를 기준으로 보여준다. 2000/01/01 ~ 2099/12/31

SELECT TO_DATE('99/10/11', 'RR/MM/DD'), TO_DATE('49/10/11', 'RR/MM/DD')
FROM DUAL;  -- R은 50 기준으로 100년을 잘라 보여준다. 1950/01/01 ~ 2049/12/31

-- 8. -------------------------------------------------------------------------
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE STUDENT_NO NOT LIKE 'A%';

-- 9. -------------------------------------------------------------------------
SELECT ROUND(AVG(POINT), 1) 평점
FROM TB_GRADE
WHERE STUDENT_NO = 'A517178';

-- 10. -------------------------------------------------------------------------
SELECT DEPARTMENT_NO 학과번호, COUNT(*) "학생수(명)"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY 1;

-- 11. -------------------------------------------------------------------------
SELECT COUNT(*)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

-- 12. -------------------------------------------------------------------------
SELECT SUBSTR(TERM_NO,0,4) 년도 , ROUND(AVG(POINT),1) "년도 별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO,0,4)
ORDER BY 1; 

-- 13. -------------------------------------------------------------------------
SELECT DEPARTMENT_NO 학과코드명, SUM(DECODE(ABSENCE_YN, 'Y', 1, 0)) "휴학생 수"
FROM TB_STUDENT
GROUP BY DEPARTMENT_NO
ORDER BY 1;

-- 14. -------------------------------------------------------------------------
SELECT STUDENT_NAME 동일이름, COUNT(STUDENT_NAME) "동명인 수"
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(STUDENT_NAME)>1
ORDER BY 1;


-- 15. -------------------------------------------------------------------------
SELECT SUBSTR(TERM_NO,0,4),SUBSTR(TERM_NO,5,2),AVG(POINT) 
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY TERM_NO 

UNION

SELECT SUBSTR(TERM_NO, 0, 4), NULL ,ROUND(AVG(POINT),1)
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY SUBSTR(TERM_NO, 0, 4)

UNION 

SELECT NULL, NULL, ROUND(AVG(POINT),1)
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY STUDENT_NO;










