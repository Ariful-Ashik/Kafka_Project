CREATE TABLE EMPLOYEE (
                          ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                          NAME VARCHAR(255),
                          ADDRESS VARCHAR(255),
                          PHONE VARCHAR(255),
                          EMAIL VARCHAR(255)
);


INSERT INTO employee (name, address, phone, email) VALUES ('John Doe', '123 Main St', '555-1234', 'john.doe@example.com');
INSERT INTO employee (name, address, phone, email) VALUES ('Jane Smith', '456 Elm St', '555-5678', 'jane.smith@example.com');
INSERT INTO employee (name, address, phone, email) VALUES ('Alice Johnson', '789 Oak St', '555-9012', 'alice.johnson@example.com');


-- INSERT INTO employeeStore (id, name,Address,Phone,Email) VALUES (1, 'ABC',"BD","01234567","A@A.com");
-- -- INSERT INTO employeeStore (id, name) VALUES (2, 'France');
-- -- INSERT INTO employeeStore (id, name) VALUES (3, 'Brazil');
-- -- INSERT INTO employeeStore (id, name) VALUES (4, 'Italy');
-- -- INSERT INTO employeeStore (id, name) VALUES (5, 'Canada');