<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title>Benefícios</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">

		<style>
			.btn-incluir {
				width: 90px;
				margin-top: 25px;
			}

			.btn-alterar {
			
				margin-right: 8px;
			}

			.btn-lancar {
				width: 158px;
				margin-top: 25px;
			}

		</style>
	</head>

	<body>
		<div class="container">
			<h3 style="margin-top:30px;color:#337AB7"><b>Benefícios</b></h3>
			
			
			<div class="row">
				<div class="col-md-12">
					<button type="button" class="btn btn-primary pull-left">Gerenciar Benefícios</button>
					<button type="button" style="margin-left:10px;" class="btn btn-primary pull-left">Vizualizar Lançamentos</button>
				</div>
			</div>
	
			<h4 class="pull-left" style="margin-top:40px; color:#337AB7"><b>Últimos Lançamentos</b></h4>

			<div class="row">
				<div class="col-md-12">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>ID Lançamento</th>
								<th>ID Funcionário</th>
								<th>Funcionário</th>
								<th>CPF</th>
								<th>Data</th>
								<th>Valor R$</th>					
							</tr>
						</thead>

						<tbody>
							<tr>
								<th scope="row">2</th>
								<td>46456</td>
								<td>Arnaldo Cezar Coelho</td>
								<td>111.222.333-44</td>
								<td>11/10/2017 14:36</td>
								<td>100,00</td>
							</tr>

							<tr>
								<th scope="row">1</th>
								<td>76899</td>
								<td>Galvão Bueno</td>
								<td>555.666.777-88</td>
								<td>11/10/2017 16:45</td>
								<td>368,60</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<button type="button" class="btn btn-primary pull-right disabled">Definir Benefícios Padrão</button>
					<button type="button" class="btn btn-primary pull-right btn-alterar disabled">Realizar Lançamentos</button>
				</div>
			</div>
		</div>

		<script
  src="http://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<script src="js/scripts.js"></script>
	</body>
</html>