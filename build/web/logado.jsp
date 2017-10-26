<%-- 
    Document   : logado
    Created on : 05/10/2017, 22:16:08
    Author     : Thander
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SGM- SISTEMA</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/normalize.css" rel="stylesheet">
    <link href="css/reset.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700" rel="stylesheet">
</head>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  
  <body>
    
<span class="btop"></span>
<div class="container">
<!--   <img src="img/bg-sgm.png" class="imgbg"> -->
<input type="checkbox" id="bt_menu">
<label for="bt_menu" id="bth">&#9776;</label>

      <nav class="menu">
        <ul>
          <li><a href="logado.jsp" id="v"><span class="seta"></span>Cadastro</a>
            <ul id="show">
              <li><a href="" data-toggle="modal" data-target="#modalEquipamento">Equipamento</a></li>
              <li><a href="" data-toggle="modal" data-target="#modalMotorista">Motorista</a></li>
              <li><a href="">Manutenção</a></li>
              <li><a href="">Usuário</a></li>
            </ul>
          </li>
          <li><a href="" id="v"><span class="setar"><span class="seta"></span>Relatório</a>
            <ul>
              <li><a href="">Equipamento</a></li>
              <li><a href="">Motorista</a></li>
            </ul>
          </li>
        </ul>
      </nav>
</div>

  <!-- Modal Motorista -->
  <div class="modal fade modalp" id="modalMotorista" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content center">
        <form action="" method="post">

          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" style="text-align: center;">Cadastro de Motorista</h4>
          </div>
          <div class="modal-body">
            <label for="nomeMotorista">Nome</label>
            <input type="text" class="form-control" id="nomeMotorista" placeholder="Digite seu nome">
            <br>
            <label for="cpfMotorista">CPF</label>
            <input type="text" class="form-control" id="cpfMotorista" placeholder="Digite seu cpf">
          </div>
          <div class="modal-footer">
            <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
            <button type="submit" class="btn btn-primary">Cadastrar</button>
          </div>

        </form>
      </div>
      
    </div>
  </div>

  <!-- Modal Equipamento -->
  <div class="modal fade modalp" id="modalEquipamento" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <form action="" method="post">

          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" style="text-align: center;">Cadastro de Motorista</h4>
          </div>
          <div class="modal-body">
            <label for="placaEquipamento">Placa</label>
            <input type="text" class="form-control" id="placaEquipamento" placeholder="Digite a placa">
            <br>
            <label for="modeloEquipamento">Modelo</label>
            <input type="text" class="form-control" id="modeloEquipamento" placeholder="Digite o modelo ">
          </div>
          <div class="modal-footer">
            <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
            <button type="submit" class="btn btn-primary">Cadastrar</button>
          </div>

        </form>
      </div>
      
    </div>
  </div>

  
  <span class="bfooter"></span>

    <script src="js/libs/jquery-1.11.2.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script>
$(document).ready(function(){
    $("#bt_menu").click(function(){
        $("#bth").hide();
        $('.menu').show();
    });
    $("#v").click(function(){
        $(".menu").show();
        $(".menu").hide();
    });
});
    </script>
  </body>
</html>