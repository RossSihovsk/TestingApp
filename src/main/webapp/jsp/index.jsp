<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>TestApp page</title>
</head>
<body>

<h1>Тестове завдання </h1>
<p>Всі результати виволяться в консоль аплікації</p>
<h2> Дістати всіх Users, в яких age більше за якесь значення </h2>
<form:form method="post" action="/task1" >
    <input type="number" placeholder="age" name="age">

    <input type="submit" value="Тисни сюди"/>
</form:form>
<hr>
<h2> Дістати всіх Users з Articles, в яких color якесь певне значення з enum-а </h2>
<form:form method="post" action="/task2" >
<select name="color">
    <option name="WHITE">WHITE</option>
    <option name="BLACK">BLACK</option>
    <option name="RED">RED</option>
    <option name="BLUE">BLUE</option>
    <option name="GREEN">GREEN</option>
</select>
    <input type="submit" value="Тисни сюди"/>
</form:form>
<hr>

<h2> Дістати унікальні name з Users, в яких більше ніж 3 Articles </h2>
<form:form method="post" action="/task3" >
    <input type="number"  name="articles" placeholder="articles">

    <input type="submit" value="Тисни сюди"/>
</form:form>
<hr>

<h2> Зберегти User та Article </h2>
<form:form method="POST"  action="/task4">
    User name: <input type="text"  name="name"> <br><br>
    User age: <input type="number"  name="age" value="age"><br><br>
    Article text:<textarea name="text"> </textarea> <br><br>
    Article color: <select name="color">
    <option name="WHITE">WHITE</option>
    <option name="BLACK">BLACK</option>
    <option name="RED">RED</option>
    <option name="BLUE">BLUE</option>
    <option name="GREEN">GREEN</option>
</select><br><br>

    <input type="submit" value="Тисни сюди"/>
</form:form>

</body>
</html>