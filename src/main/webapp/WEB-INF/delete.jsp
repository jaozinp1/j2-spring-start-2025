<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Remover Tarefa</title>
    </head>
    <body>
        <h1>Remover Tarefa</h1>
        <p>Tem certeza que deseja remover "${tarefa.nome}" ?</p>
        <form action="/tarefas/delete" method="post">
            <input type="hidden" name="id" value="${tarefa.id}" />
            <button type="submit">Excluir</button>
        </form>
    </body>
</html>