# Initial-Api

## Setup

### Run application

### After the initialization of Spring Boot:

Please run this SQL script after starting Spring Boot in your database to have a
default admin user :

    insert into my_user(
        id,lastname,firstname,sex,birth_date,
        address,phone,email,username,password,role
    ) values (
        0,'admin','admin','M','2003-05-13',
        'address_admin','1234567890','admin@gmail.com','admin',
        '$2a$10$y6n7HoU.lCetC6/mj4rPLOdbSk.EE8DfUKmtaqsq.6WlY/lrRPCUW',
        'manager'
    );

### You can now control the API with the credentials:

    {
        username: admin,
        password: admin
    }