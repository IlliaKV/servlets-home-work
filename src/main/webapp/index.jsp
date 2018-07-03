<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.first.servlet.domain.Developer" %>

<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Клієнти банку</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
<body>
    <div class="w3-container w3-blue w3-margin-bottom">
        <h1>Розробники</h1>
    </div>

    <div class="w3-container w3-padding">
        <ol class="w3-ul">
            <%
                List<Developer> developers = (List<Developer>) request.getAttribute("developers");
                for(Developer developer: developers) {
                    out.print("<li class=\"w3-yellow\">" + developer.getFirstName() + " " + developer.getLastName() +
                                " <a class=\"w3-button w3-green\" href=\"/developer_edit?idDeveloper=" + developer.getId() + "\">Редагувати</a>");
                    out.print(" <a class=\"w3-button w3-blue\" href=\"/developer/skills?idDeveloper=" + developer.getId() + "\">Навички розробника</a>");
                    out.println("</li>");
                }
            %>
        </ol>

        <a href="/developer_add" class="w3-margin-top w3-button w3-green w3-right">Додати нового розробника</a>
    </div>
</body>
</html>
