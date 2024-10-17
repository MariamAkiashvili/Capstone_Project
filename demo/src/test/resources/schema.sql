
-- Drop existing tables (if any) to avoid conflicts during testing
DROP TABLE IF EXISTS access_on_material CASCADE;
DROP TABLE IF EXISTS student_group CASCADE;
DROP TABLE IF EXISTS material CASCADE;
DROP TABLE IF EXISTS student_additional_info CASCADE;
DROP TABLE IF EXISTS course CASCADE;
DROP TABLE IF EXISTS university_user CASCADE;
DROP TABLE IF EXISTS faculty CASCADE;
DROP TABLE IF EXISTS university_group CASCADE;
DROP TABLE IF EXISTS permission_group CASCADE;
DROP TABLE IF EXISTS access_type CASCADE;
DROP TABLE IF EXISTS user_role CASCADE;

-- Create user_role table
CREATE TABLE user_role (
    user_role_code VARCHAR(50) PRIMARY KEY,
    user_role_name VARCHAR(50) NOT NULL
);

-- Create access_type table
CREATE TABLE access_type (
    access_type_code VARCHAR(50) PRIMARY KEY,
    access_type_name VARCHAR(100) NOT NULL
);

-- Create permission_group table
CREATE TABLE permission_group (
    permission_group_id SERIAL PRIMARY KEY,
    user_role_code VARCHAR(50) NOT NULL,
    access_type_code VARCHAR(50) NOT NULL,
    CONSTRAINT fk_userRole FOREIGN KEY (user_role_code) REFERENCES user_role (user_role_code) ON DELETE NO ACTION,
    CONSTRAINT fk_accessType FOREIGN KEY (access_type_code) REFERENCES access_type (access_type_code) ON DELETE NO ACTION
);

-- Create university_group table
CREATE TABLE university_group (
    university_group_id SERIAL PRIMARY KEY,
    university_group_name VARCHAR(100) NOT NULL,
    university_group_code VARCHAR(50) UNIQUE
);

-- Create faculty table
CREATE TABLE faculty (
    faculty_code VARCHAR(50) NOT NULL PRIMARY KEY,
    faculty_name VARCHAR(150) NOT NULL,
    description VARCHAR(500)
);

-- Create university_user table
CREATE TABLE university_user (
    university_user_id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    email VARCHAR(50),
    user_role_code VARCHAR(50) NOT NULL,
    password VARCHAR(500),
    CONSTRAINT fk_user_role FOREIGN KEY (user_role_code) REFERENCES user_role (user_role_code) ON DELETE NO ACTION
);

-- Create course table
CREATE TABLE course (
    course_code VARCHAR(50) PRIMARY KEY,
    course_name VARCHAR(150) NOT NULL,
    lecturer_id BIGINT,
    max_number_of_students INT NOT NULL,
    faculty_code VARCHAR(50) NOT NULL,
    CONSTRAINT fk_lecturer FOREIGN KEY (lecturer_id) REFERENCES university_user (university_user_id) ON DELETE NO ACTION,
    CONSTRAINT fk_faculty FOREIGN KEY (faculty_code) REFERENCES faculty (faculty_code) ON DELETE NO ACTION
);

-- Create student_additional_info table
CREATE TABLE student_additional_info (
    additional_info_id BIGINT PRIMARY KEY,
    university_user_id BIGINT NOT NULL,
    faculty_code VARCHAR(100) NOT NULL,
    has_active_status BOOLEAN,
    current_study_year INT,
    phone VARCHAR(50),
    CONSTRAINT fk_user FOREIGN KEY (university_user_id) REFERENCES university_user (university_user_id) ON DELETE NO ACTION,
    CONSTRAINT fk_faculty FOREIGN KEY (faculty_code) REFERENCES faculty (faculty_code) ON DELETE NO ACTION
);

-- Create material table
CREATE TABLE material (
    material_id BIGSERIAL PRIMARY KEY,
    material_name VARCHAR(200) NOT NULL,
    description VARCHAR(500) NULL,
    material_upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    material_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    uploaded_by_user_id BIGINT NOT NULL,
    link VARCHAR(1000) NOT NULL,
    s3_address VARCHAR(500),
    is_online_material BOOLEAN,
    CONSTRAINT fk_uploadByUser FOREIGN KEY (uploaded_by_user_id) REFERENCES university_user (university_user_id) ON DELETE NO ACTION
);

-- Create student_group table
CREATE TABLE student_group (
    student_group_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    group_id SERIAL NOT NULL,
    added_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES university_user (university_user_id) ON DELETE NO ACTION,
    CONSTRAINT fk_group_id FOREIGN KEY (group_id) REFERENCES university_group (university_group_id) ON DELETE NO ACTION
);

-- Create access_on_material table
CREATE TABLE access_on_material (
    access_on_material_id BIGSERIAL PRIMARY KEY,
    material_id BIGINT NOT NULL,
    university_group_id SERIAL NOT NULL,
    access_type_code VARCHAR(50) NOT NULL,
    CONSTRAINT fk_material_id FOREIGN KEY (material_id) REFERENCES material (material_id) ON DELETE NO ACTION,
    CONSTRAINT fk_group_id FOREIGN KEY (university_group_id) REFERENCES university_group (university_group_id) ON DELETE NO ACTION,
    CONSTRAINT fk_accessType FOREIGN KEY (access_type_code) REFERENCES access_type (access_type_code) ON DELETE NO ACTION
);
