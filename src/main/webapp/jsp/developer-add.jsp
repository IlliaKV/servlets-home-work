<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.first.servlet.domain.Developer" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Додавання розробника</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>


    <div class="w3-container w3-blue">
        <a href="/" class="w3-button w3-margin w3-large w3-yellow">Всі розробники</a>
        <h1>Додавання розробника</h1>
    </div>

    <br/>

    <div class="w3-container w3-blue w3-padding">
        <form method="post" action="/developer_add">
            <div class="w3-container w3-light-grey w3-margin w3-padding">
                <h3>Ім'я:</h3>
                <input class="w3-input" type="text" name="developerFirstName" value="">
            </div>

            <div class="w3-container w3-light-grey w3-margin w3-padding">
                <h3>Прізвище:</h3>
                <input class="w3-input" type="text" name="developerLastName" value="">
            </div>

            <div class="w3-container">
                <input type="submit" class="w3-button w3-green w3-right w3-large" value="Зберегти"/>
            </div>
        </form>
    </div>
</body>
</html>
