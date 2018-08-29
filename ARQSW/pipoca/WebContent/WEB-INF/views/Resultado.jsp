<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>
	<div style="text-align: center;">
		<h1>Filme cadastrado com sucesso!</h1>

		<h3>${filme.nome}</h3>
		<h3>${filme.dataLancamento}</h3>
		<h3>${filme.diretor}</h3>
		<h3>${filme.descricao}</h3>
		<h3>${filme.popularidade}</h3>
	</div>
</body>
</html>