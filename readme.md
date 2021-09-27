Для запуску проекту попередньо необхідно змінити данні в application.properties
для підключення уже існуючої у вас Бази данних та свох данні(Логін та пароль)
для коректного зєднання.
***
Посилання для добавлення колекції запитів
https://www.getpostman.com/collections/4ebbecd5a890f853f5f8
Починаючи з метода task1 потрібна авторизація за допомогою токена який генерується в Sign-in
***
Sign-Up  
Method:POST  
localhost:8080/security/signup  
Body: raw:JSON  
{  
"name": "test",  
"email": "test",  
"password": "test",  
"role": ["user"]  
}  


Sign-in  
Method: POST  
localhost:8080/security/signin  
Body: raw:JSON  
  
{  
"email": "test",  
"password": "test"  
}
  
До цих методів є доступ авторизованим користувачам з  
будь-яким рівнем доступу  
Task1  
Method: POST  
Authorization: Bearer Token (токен згенерований в response з Sign-in )  
localhost:8080/main/task1  
Body: x-www-form-urlencoded  
key:age   value:25  


Task2  
Method: POST  
Authorization: Bearer Token (токен згенерований в response з Sign-in )  
localhost:8080/main/task2  
Body: x-www-form-urlencoded  
key:color   value:WHITE  



Task3  
Method: POST  
Authorization: Bearer Token (токен згенерований в response з Sign-in )  
localhost:8080/main/task3  
Body: x-www-form-urlencoded  
key:articles   value:2  


Task4  
Method: POST  
Authorization: Bearer Token (токен згенерований в response з Sign-in )  
localhost:8080/main/task4  
key:name   value:testName  
key:age    value:25  
key:text   value:test text666  
key:color  value:RED  

До цього метода доступ є і в не авторизованих користувачів  
All access  
Method: GET  
localhost:8080/main/all  

  
До цтого метода доступ є у авторизованих користувачів  
з рівнем USER  і вище  
User access  
Authorization: Bearer Token (токен згенерований в response з Sign-in )  
Method: GET  
localhost:8080/main/user  

  
До цтого метода доступ є у авторизованих користувачів  
з рівнем MODERATOR  і вище  
Moderator access  
Authorization: Bearer Token (токен згенерований в response з Sign-in )  
Method: GET  
localhost:8080/main/mod  


До цтого метода доступ є у авторизованих користувачів  
з рівнем ADMIN  
Admin access  
Authorization: Bearer Token (токен згенерований в response з Sign-in )  
Method: GET  
localhost:8080/main/admin  




