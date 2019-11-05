#1. 查询 "001" 课程比 "002" 课程成绩高的所有学生的学号； (子查询 / 连表) 
SELECT
	a.student_id
FROM
	t_score a,
	(
		SELECT
			*
		FROM
			t_score
		WHERE
			course_id = 002
	) b
WHERE
	a.student_id = b.student_id
AND a.score > b.score
AND (
	a.course_id = 001
	OR a.course_id = 002
);

#2. 查询平均成绩大于60分的同学的学号和平均成绩：
 SELECT
	student_id,
	avg(score) AS score
FROM
	t_score
GROUP BY
	student_id
HAVING
	score > 60;

#3. 查询所有同学的学号、姓名、选课数、总成绩 (比较有难度GROUP BY和 函数) 
SELECT
	b.student_name,
	a.student_id,
	sum(a.score),
	count(a.course_id) AS scores
FROM
	t_score a
JOIN t_student b ON a.student_id = b.student_id
GROUP BY
	student_id;

#4. 查询 姓 李 同学的个数 (考察like和count) 
SELECT
	count(*)
FROM
	t_student
WHERE
	student_name LIKE '李%';

#5. 查询没有 003课程成绩的学生 
SELECT DISTINCT
	student_id
FROM
	t_score
WHERE
	student_id NOT IN (
		SELECT
			student_id
		FROM
			t_score
		WHERE
			course_id = 003
	);

#6.查询学过 "001" 并且也学过编号 "002" 课程的同学的学号、姓名； 
SELECT
	student_id
FROM
	t_score
WHERE
	course_id IN (001, 002)
GROUP BY
	student_id
HAVING
	count(course_id) = 2;

#7. 查询所有课程成绩小于70分的同学的学号、姓名； 
SELECT DISTINCT
	a.student_id,
	b.student_name
FROM
	t_score a
LEFT JOIN t_student b ON a.student_id = b.student_id
GROUP BY a.student_id
HAVING AVG(a.score)<70;

#8查询没有学全所有课的同学的学号、姓名； 
SELECT
	b.student_name,
	a.student_id
FROM
	t_score a
LEFT JOIN t_student b ON a.student_id = b.student_id
WHERE
	a.course_id IN (
		SELECT DISTINCT
			student_id
		FROM
			t_score
	)
GROUP BY
	a.student_id
HAVING
	count(a.course_id) < (
		SELECT
			count(DISTINCT course_id)
		FROM
			t_score
	);

#9.查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分 
SELECT
	course_id '课程ID',
	max(score) '最高分',
	min(score) '最低分'
FROM
	t_score
GROUP BY
	course_id;

#10.查询每门课程有成绩的学生数 
SELECT
	course_id,
	count(student_id)
FROM
	t_score
GROUP BY
	course_id;

#11. 查询男生、女生人数 
SELECT
	gender,
	count(student_id)
FROM
	t_student
GROUP BY
	gender;

#12统计同名同姓人数 
SELECT
	student_name,
	count(student_id)
FROM
	t_student
GROUP BY
	student_name
HAVING
	count(student_name) > 1;

