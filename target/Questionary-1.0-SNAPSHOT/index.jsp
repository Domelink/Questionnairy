<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Questionary</title>
</head>
<body>
<h1><%= "Вопрос - ответ" %>
</h1>
<form method="post" action="/Questionary" >
    <p>Предпочитаемый вид автомобиля:</p>
    <div>
        <input type="radio" id="contactChoice1"
               name="contact" value="1">
        <label for="contactChoice1">Легковой</label>
    </div>
    <div>
        <input type="radio" id="contactChoice2"
               name="contact" value="2">
        <label for="contactChoice2">Внедорожник</label>
    </div>

    <p>Что больше любите:</p>
    <div>
        <input type="radio" id="contact2Choice1"
               name="contact2" value="1">
        <label for="contact2Choice1">Водить</label>
    </div>
    <div>
        <input type="radio" id="contact2Choice2"
               name="contact2" value="2">
        <label for="contact2Choice2">Быть пассажиром</label>
    </div>

    <br/>
    <div>
        <button>Ok</button>
    </div>
</form>
