<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pr-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tarefas</title>
</head>
<body>
    <h1>Tarefas</h1>
    <form action="/tarefas/insert" method="post">
        <label for="tareda">Nova Tarefa</label>
        <input type="text" name="tarefa"/>
        <button type="submit">Salvar</button>
    </form>
    <hr/>
    <ul>
        <c:forEach var="item" items="${tarefas}">
            <li>${item.nome}</li>
        </c:forEach>
    </ul>

</body>
</html>