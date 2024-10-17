
-- Insert user roles
INSERT INTO user_role (user_role_code, user_role_name) VALUES
('ADMIN', 'Administrator'),
('STUDENT', 'Student'),
('PROFESSOR', 'Professor');

-- Insert access types
INSERT INTO access_type (access_type_code, access_type_name) VALUES
('READ', 'Read Access'),
('WRITE', 'Write Access'),
('DELETE', 'Delete Access');

-- Insert faculties
INSERT INTO faculty (faculty_code, faculty_name, description) VALUES
('CS', 'Computer Science', 'Department of Computer Science'),
('ENG', 'Engineering', 'Department of Engineering'),
('BUS', 'Business', 'Department of Business Administration');

-- Insert university groups
INSERT INTO university_group (university_group_name, university_group_code) VALUES
('Group A', 'GROUP_A'),
('Group B', 'GROUP_B'),
('Group C', 'GROUP_C');

-- Insert university users
INSERT INTO university_user (first_name, last_name, email, user_role_code, password) VALUES
('Alice', 'Johnson', 'alice.johnson@example.com', 'STUDENT', 'password123'),
('Bob', 'Smith', 'bob.smith@example.com', 'PROFESSOR', 'password123'),
('Charlie', 'Brown', 'charlie.brown@example.com', 'ADMIN', 'adminpass');

-- Insert courses
INSERT INTO course (course_code, course_name, lecturer_id, max_number_of_students, faculty_code) VALUES
('CS101', 'Introduction to Computer Science', 2, 50, 'CS'),
('ENG101', 'Fundamentals of Engineering', 2, 60, 'ENG'),
('BUS101', 'Introduction to Business', 2, 70, 'BUS');

-- Insert student additional info
INSERT INTO student_additional_info (additional_info_id, university_user_id, faculty_code, has_active_status, current_study_year, phone) VALUES
(1, 1, 'CS', TRUE, 2, '555-0123'),
(2, 1, 'ENG', TRUE, 1, '555-0456');

-- Insert materials
INSERT INTO material (material_name, description, uploaded_by_user_id, link, s3_address, is_online_material) VALUES
('Intro to CS Video', 'A video about the basics of Computer Science.', 1, 'http://example.com/materials/intro-to-cs', 's3://bucket/path/intro-to-cs.mp4', FALSE),
('Engineering Guide', 'Comprehensive guide for Engineering students.', 2, 'http://example.com/materials/engineering-guide', 's3://bucket/path/engineering-guide.pdf', TRUE),
('Business 101 PDF', 'PDF document for Business 101 course.', 2, 'http://example.com/materials/business-101', 's3://bucket/path/business-101.pdf', TRUE);

-- Insert student groups
INSERT INTO student_group (user_id, group_id) VALUES
(1, 1),
(1, 2);

-- Insert access on material
INSERT INTO access_on_material (material_id, university_group_id, access_type_code) VALUES
(1, 1, 'READ'),
(2, 1, 'WRITE'),
(3, 2, 'DELETE');
