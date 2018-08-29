<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir novo filme</title>
</head>
<body>
	<form action="inserir" method="POST">
		<label for="nome-filme">Filme:</label>
		<input id="novo-filme" type="text" name="nome">
		<br>
		<label for="data-lancamento">Data de Lançamento:</label>
		<input id="data-lancamento" type="date" name="dataLancamento">
		<br>
		<label for="diretor">Diretor:</label>
		<input id="diretor" type="text" name="diretor">
		<br>
		<label for="descricao">Descrição:</label>
		<input id="descricao" type="text" name="descricao">
		<br>
		<label for="popularidade">Popularidade:</label>
		<input id="popularidade" type="number" name="popularidade">
		<br>
		<button type="submit">Cadastrar filme</button>
	</form>
</body>
</html>