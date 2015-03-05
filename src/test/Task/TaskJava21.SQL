CREATE SCHEMA sakila;

CREATE TABLE employees
(
    employee_id INT PRIMARY KEY NOT NULL,
    first_name VARCHAR(45),
    last_name VARCHAR(45),
    email VARCHAR(45),
    phone_number VARCHAR(45),
    hire_date DATE,
    job_id INT,
    salary INT,
    commission_pct INT,
    manager_id INT,
    department_id INT
);