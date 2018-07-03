<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.first.servlet.domain.Developer" %>
<%@ page import="com.first.servlet.domain.Skill" %>
<%@ page import="java.util.Set" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>Навички розробника</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

    <% Developer developer = (Developer) request.getAttribute("developer"); %>
    <% Set<Skill> skills = (Set<Skill>) request.getAttribute("skills"); %>


    <div class="w3-container w3-blue">
        <a href="/" class="w3-button w3-margin w3-large w3-yellow">Всі розробники</a>
        <h1>Навички розробника <%= developer.getFirstName()%> <%= developer.getLastName()%></h1>
    </div>

    <br/>

    <div class="w3-container">
        <h2>Кількість навичків: <%= skills.size() %></h2>
    </div>

    <div class="w3-container w3-blue w3-padding">
        <ul class="w3-ul">
            <%
                for(Skill skill: skills) {
                    String listItem = "<li>";
                    listItem += skill.getNameSkill();
                    listItem += ", " + skill.getLevelSkill() + ".";
                    listItem += "</li>";

                    out.println(listItem);
                }
            %>
        </ul>
    </div>

    <div class="w3-container w3-margin-top">
        <a href="/developer/skill_add?idSkill=<%=developer.getId()%>" class="w3-button w3-green w3-right w3-marin-top">Додати вміння</a>
    </div>
</body>
</html>
