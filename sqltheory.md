SELECT [DISTINCT] TabNum FROM Employees WHERE Salary > 500;
SELECT Employees.TabNum, Employees.Name, Departments.Name FROM Employees 
              JOIN Departments ON Employees.DeptNum = Departments.DeptNum

SELECT Employees.TabNum, Employees.Name, Departments.Name, Cities.Name 
FROM Employees
[INNER, LEFT, ] JOIN Departments 
ON Employees.DeptNum = Departments.DeptNum
JOIN Cities 
ON Departments.City = Cities.City

SELECT Table1.Field1, Table2.Field2 
FROM Table1
CROSS JOIN Table2

WHERE

SELECT * FROM Table WHERE Field1  IS NOT NULL
SELECT * FROM Employees WHERE Name LIKE 'Ivan%'
SELECT * FROM Employees WHERE Name LIKE '___n%'
SELECT * FROM Employees WHERE Position IN ('Boss', 'Security')
SELECT * FROM Employees WHERE Salary BETWEEN 30000 AND 80000
AND, OR, NOT

SELECT *
FROM Employees
WHERE NOT (Position = 'Boss' OR Position = 'Security')

SELECT * FROM Employees ORDER BY DeptNum ASC, Salary DESC

SELECT MAX(Salary) FROM Employees

SELECT COUNT (*) FROM Employees

SELECT DeptNum, 

DDL
_______
CREATE TABLE
DROP TABLE
ALTER TABLE

DML
_______
SELECT
INSERT
DELETE
UPDATE

TCL
_____
COMMIT
ROLLBACK
SET TRANSACTION

DCL
___
GRANT 
REVOKE 

ТИПЫ
____
SERIAL
SMALLSERIAL
BIGSERIAL
SMALLINT
INTEGER
BIGINT
DECIMAL
REAL
DOUBLE PRECISION

MONEY

CHARACTER(30) / CHAR(30)
CHARACTER VARYING(30) / VARCHAR(30)
TEXT

BYTEA

TIMESTAMP
TIMESTAMP WITH TIME ZONE
DATE
TIME
TIME WITH TIME ZONE
INTERVAL

BOOLEAN

CIDR
INET
MACADDR
MACADDR8

JSON
UUID
XML

CONSTRAINTS = ОГРАНИЧЕНИЯ
_______
PRIMARY KEY
UNIQUE
NULL/NOT NULL
CHECK

CONSTRAINT



postgres
postgres
5432
localhost


1. IDE - Idea https://www.jetbrains.com/ru-ru/idea/download/#section=windows Ultimate version
2. PostgreSQL - https://www.postgresql.org/download/
   psql
   pgAdmin
   
3. Данные для регистрации:
 
   имя пользователя postgres
   пароль postgres
   порт 5432
   сервер localhost
   
4. Database - 

----------------
ON DELETE
ON UPDATE

CASCADE
RESTRICT
NO ACTION 
SET NULL 
SET DEFAULT



