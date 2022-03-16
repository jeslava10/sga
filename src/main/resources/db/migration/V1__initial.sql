
CREATE TABLE employees (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          first_name VARCHAR(250) NOT NULL,
                          last_name VARCHAR(250) NOT NULL,
                          email VARCHAR(250) NOT NULL

);


CREATE TABLE activities (
                                    id INT AUTO_INCREMENT  PRIMARY KEY,
                                    description VARCHAR(200) NOT NULL,
                                    employee_id INT NULL,
                                    execution_date BIGINT(10) NULL,
                                    status INT NOT NULL,
                                    CONSTRAINT employees_activity
                                        FOREIGN KEY (employee_id)
                                            REFERENCES employees (id));

INSERT INTO employees (first_name, last_name,email) VALUES
    ('James', 'mill','a@a.com')