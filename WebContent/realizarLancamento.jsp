<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title>Realizar Lançamentos</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<style>
			
			
		</style>
	</head>

	<body>
		<div class="container">
			<h3 style="margin-top:30px;color:#337AB7"><b>Realizar Lançamentos</b></h3>
			<h4 style="margin-top:30px;color:#337AB7"><b>Funcionário</b></h4>

			<form action="#" method="POST">
				<div class="row">
					<div class="col-md-4">
						  <div class="form-group">
						    <label for="funcionario">Nome</label>
						    <input type="text" class="form-control" id="funcionario" placeholder="Funcionário" value="Alisson Silva" readonly>
						  </div>
					</div>
					<div class="col-md-4">
						  <div class="form-group">
						    <label for="id">ID</label>
						    <input type="number" class="form-control" id="id" placeholder="ID" value="87964" readonly>
						  </div>
					</div>
					<div class="col-md-4">
						  <div class="form-group">
						    <label for="cpf">CPF</label>
						    <input type="text" class="form-control" id="cpf" placeholder="CPF" value="400.200.100-50" readonly>
						  </div>
					</div>
				</div>

				<h4 style="margin-top:30px; color:#337AB7"><b>Incluir Benefícios</b></h4>
				<div class="row">
					<div class="col-md-8">
						<div class="form-group">
						    <label for="beneficio">Selecione o benefício</label>
						    <select id="beneficio" class="form-control">
							  <option>Vale Transporte</option>
							  <option>Vale Alimentação</option>
							  <option>Plano de Saúde</option>
							</select>
						  </div>
					</div>
					<div class="col-md-4">
						  <div class="form-group">
						    <label for="valor">Valor R$</label>
						    <input type="text" class="form-control" id="valor" placeholder="Valor" value="">
						  </div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-4">
							<div class="form-group">
								<label for="desconto">Desconto</label>
								<div class="input-group">
							      <input type="text" class="form-control" id="desconto">
							      <div class="input-group-btn">
							        <select id="tipo" style="width:70px" class="form-control">
							  			<option>R$</option>
							 			 <option>%</option>
									</select>  
							      </div><!-- /btn-group -->
								</div><!-- /input-group -->
							</div>
					</div>
					<div class="col-md-4">
						  <div class="form-group">
						    <label for="tipo">Período</label>
						    <select id="tipo" class="form-control">
							  <option>Semanal</option>
							  <option>Quinzenal</option>
							  <option>Mensal</option>
							  <option>Trimestral</option>
							  <option>Semestral</option>
							  <option>Anual</option>
							</select>
						  </div>
					</div>
					<div class="col-md-4">
						<button type="submit" style="width: 90px; margin-top: 25px;" class="btn btn-success pull-right disabled">Incluir</button>
					</div>
				</div>
			</form>
			
			
			<h4 class="pull-left" style="margin-top:40px; color:#337AB7"><b>Lançamento</b></h4>
			<input type="date" style="width: 160px; margin: 35px 0px 0px 10px;" class="form-control pull-left">

			<div class="row">
				<div class="col-md-12">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>Descrição</th>
								<th>Desc %</th>
								<th>Desc R$</th>
								<th>Valor R$</th>
								<th>Período</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Vale Alimentação</td>
								<td>0</td>
								<td>0</td>
								<td>100,00</td>
								<td>Mensal</td>
							</tr>

							<tr>
								<th scope="row">2</th>
								<td>Vale Transporte</td>
								<td>0</td>
								<td>0</td>
								<td>90,00</td>
								<td>Mensal</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<button type="button" class="btn btn-danger pull-right disabled">Remover</button>
					<button type="button" style="margin-right: 8px;" class="btn btn-warning pull-right disabled">Alterar</button>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<button type="button" style="width: 158px;margin-top: 25px; margin-bottom: 25px;"class="btn btn-primary pull-right disabled">Efetuar Lançamento</button>
				</div>
			</div>
		</div>

		<script
  src="http://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	</body>
</html>