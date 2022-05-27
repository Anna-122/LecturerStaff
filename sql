CREATE TABLE lecturer
(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(20) NOT NULL ,
    surname VARCHAR(20) NOT NULL
);

CREATE TABLE student
(
    id  INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name  VARCHAR(20) NOT NULL,
    surname VARCHAR(20)  NOT NULL,
--     lecturer_id  INT  NOT NULL
);

CREATE TABLE questions(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    question TEXT (400) NOT NULL,
--     lecturer_id  INT  NOT NULL
    );

CREATE TABLE answers(
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    answer VARCHAR (100)  NOT NULL,
    answer_boolean BIT  NOT NULL,
    question_id  INT  NOT NULL

 );

 CREATE TABLE statistics(
     id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
     number_of_correct_answers INT  NOT NULL,
--      student_id  INT  NOT NULL

  );


-- ALTER TABLE student
--     ADD FOREIGN KEY (id) REFERENCES lecturer (id) ;
--
-- ALTER TABLE answers
--     ADD FOREIGN KEY (id) REFERENCES questions (id) ;
--
-- ALTER TABLE questions
--     ADD FOREIGN KEY (id) REFERENCES lecturer (id) ;
--
--
-- ALTER TABLE statistics
--     ADD FOREIGN KEY (id) REFERENCES student (id)











--
-- CREATE TABLE lecturer
-- (
--     id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
--     name VARCHAR(20) NOT NULL ,
--     surname VARCHAR(20) NOT NULL
-- );
--
-- CREATE TABLE student
-- (
--     id  INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
--     name  VARCHAR(20) NOT NULL,
--     surname VARCHAR(20)  NOT NULL
--
-- );
--
-- CREATE TABLE questions(
--                           id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
--                           question TEXT (400) NOT NULL
--
-- );
--
-- CREATE TABLE answers(
--                         id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
--                         answer VARCHAR (100)  NOT NULL,
--                         answer_boolean BIT  NOT NULL
--
--
-- );
--
-- CREATE TABLE statistics(
--                            id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
--                            number_of_correct_answers INT  NOT NULL
-- );