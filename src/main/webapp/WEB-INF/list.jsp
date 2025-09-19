<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Tarefas</title>
    </head>
    <body>
        <h1>Tarefas</h1>
        <form action="/tarefas/insert" method="post">
            <label for="tarefa">Nova Tarefa</label>
            <input type="text" name="tarefa" />
            <button type="submit">Salvar</button>
        </form>
        <hr />
        <ul>
            <c:forEach var="item" items="${tarefas}">
                <li>
                    <a href="/tarefas/delete?id=${item.id}">[ Excluir ] </a>
                    <a href="/tarefas/update?id=${item.id}">${item.nome}</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>