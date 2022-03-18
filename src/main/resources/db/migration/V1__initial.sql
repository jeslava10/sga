
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
                                    execution_date DATE NULL,
                                    execution_hour INT NULL,
                                    status_activity INT NOT NULL,
                                    CONSTRAINT employees_activity
                                        FOREIGN KEY (employee_id)
                                            REFERENCES employees (id));

INSERT INTO employees (first_name, last_name,email) VALUES
    ('Juan', 'Eslava','Juan.Eslava@gmail.com');

INSERT INTO employees (first_name, last_name,email) VALUES
    ('Alberto', 'Perez','Alberto.Pereza@gmail.com');

INSERT INTO employees (first_name, last_name,email) VALUES
    ('Jaime', 'Gomez','Jaime.Gomez@gmail.com');

