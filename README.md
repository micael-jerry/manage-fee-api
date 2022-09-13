# Initial-Api

## Setup

### Run application

### After the initialization of Spring Boot:
Please run this SQL script after starting Spring Boot in your database to have a 
default admin user :

    insert into my_user values  (1,'jerry','micael',
    '$2a$10$zjYnPNWQ7B5CtGzKqJGyMe7iaiosJthEhHlQZryQTpHOPiapbb4DS',
    'admin','admin');`

### You can now control the API with the credentials:

    {
        username: admin,
        password: admin
    }