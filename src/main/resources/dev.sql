CREATE TABLE jis6.developers (
                                 id INT NOT NULL AUTO_INCREMENT,
                                 name VARCHAR(50) NOT NULL,
                                 specialty VARCHAR(50) NOT NULL,
                                 salary INT NOT NULL,
                                 PRIMARY KEY (id));

INSERT INTO jis6.developers (name, specialty, salary) VALUES ('Proselyte', 'Java', '2000');
INSERT INTO jis6.developers (name, specialty, salary) VALUES ('Peter','C++', '3000');
INSERT INTO jis6.developers (name, specialty, salary) VALUES ('AsyaSmile', 'UI/UX', '2000');
