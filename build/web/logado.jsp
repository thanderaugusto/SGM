<%-- 
    Document   : logado
    Created on : 05/10/2017, 22:16:08
    Author     : Thander
--%>


<%@page import="java.util.List"%>
<%@page import="DAO.MotoristaDAO"%>
<%@page import="modelo.Motorista"%>
<%@page import="DAO.EquipamentoDAO"%>
<%@page import="modelo.Equipamento"%>
<%@page contentType="text/html: charset=UTF-8;" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SGM- SISTEMA DE GERENCIAMENTO E MANUTENÇÃO</title>
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
          <li><a href="" id="v"><span class="seta"></span>Cadastro</a>
            <ul id="show">
              <li><a href="" data-toggle="modal" data-target="#modalEquipamento">Equipamento</a></li>
              <li><a href="" data-toggle="modal" data-target="#modalMotorista">Motorista</a></li>
              <li><a href="" data-toggle="modal" data-target="#modalManutencao">Manutenção</a></li>
              <li><a href="" data-toggle="modal" data-target="#modalUsuario">Usuário</a></li>
            </ul>
          </li>
          <li><a href="" id="v"><span class="setar"><span class="seta"></span>Relatório</a>
            <ul>
              <li><a href="">Equipamento</a></li>
              <li><a href="ServletRelEquipamento">Motorista</a></li>
            </ul>
          </li>
        </ul>
      </nav>
      <%
          String nome = (String)request.getSession().getAttribute("nome");
          if(nome=="" || nome==null){
              nome ="erro   ";
          }
      %>

      <div class="btSair">
          <%=nome%> - 
          <a type="button" href="./logoff.jsp">Sair</a>
      </div>
</div>

  <!-- Modal Motorista -->
  <div class="modal fade modalp" id="modalMotorista" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content center">
        <form action="ServletMotorista" method="post" accept-charset="utf-8">

          <div class="modal-header modal-header-warning">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" style="text-align: center;">Cadastro de Motorista</h4>
          </div>
          <div class="modal-body">
            <label for="nomeMotorista">Nome</label>
            <input type="text" class="form-control" id="nomeMotorista" name="nomeMotorista" placeholder="Digite seu nome" required>
            <br>
            <label for="cpfMotorista">Data Nascimento</label>
            <input type="date" class="form-control" id="nascMotorista" name="nascMotorista" placeholder="Digite sua data de nascimento" required>
            <br>
            <label for="cpfMotorista">CPF</label>
            <input type="text" class="form-control" id="cpfMotorista" name="cpfMotorista" placeholder="Digite seu cpf" required>
          </div>
          <div class="modal-footer">
            <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
            <button type="submit" class="btn btn-warning-mod">Cadastrar</button>
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
        <form action="ServletEquipamento" method="post" accept-charset="utf-8">

          <div class="modal-header modal-header-warning">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" style="text-align: center;">Cadastro de Equipamento</h4>
          </div>
          <div class="modal-body">
            <label for="frotaEquip">Frota</label>
            <input type="text" class="form-control" id="frotaEquip" name="frotaEquip" placeholder="Digite a frota" required>
            <br>
            <label for="marcaEquip">Marca</label>
            <input type="text" class="form-control" id="marcaEquip" name="marcaEquip" placeholder="Digite a marca" required>
            <br>
            <label for="modeloEquip">Modelo</label>
            <input type="text" class="form-control" id="modeloEquip" name="modeloEquip" placeholder="Digite o modelo " required>
            <br>
            <label for="anoEquip">Ano</label>
            <input type="text" class="form-control" id="anoEquip" name="anoEquip" placeholder="Digite o ano " required>
          </div>
          <div class="modal-footer">
            <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
            <button type="submit" class="btn btn-warning-mod" o>Cadastrar</button>
          </div>

        </form>
      </div>
      
    </div>
  </div>
  
  <!-- Modal Manutenção -->
  <div class="modal fade modalp" id="modalManutencao" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <form action="ServletManutencao" method="post" accept-charset="utf-8">

          <div class="modal-header modal-header-warning">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" style="text-align: center;">Cadastro de Manutenção</h4>
          </div>
          <div class="modal-body" >
            <div class="input-manut">
              <label for="dataEntManutencao">Data Entrada</label>
              <input type="text" class="form-control" id="dataEntManutencao" name="dataEntManutencao" placeholder="Digite a data" required>
            </div>
            <div class="input-manut">
              <label for="dataSaidManutencao">Data Saída</label>
              <input type="text" class="form-control" id="dataSaidManutencao" name="dataSaidManutencao" placeholder="Digite a data" required>
            </div><br><br>
            <label for="tipoManutencao">Tipo de Manutenção</label>
              <select class="form-control" id="tipoManutencao" name="tipoManutencao" required>
                <option value="" selected disabled>Selecione a manutenção</option>
                <option>A - MANUTENÇÃO PREVENTIVA</option>
                <option>B - MANUTENÇÃO CORRETIRA</option>
                <option>C - REPAROS LEVES</option>
              </select><br>
            <div class="select-frota">
              <label for="frotaManutencao">Frota</label>
              <select class="form-control" id="frotaManutencao" name="frotaManutencao" required>
                <option value="" selected>Selecione Frota</option
                  <%
                    EquipamentoDAO equip = new EquipamentoDAO();
                    List<Equipamento> equipamentos = equip.retrieveAll();
                        for(Equipamento e: equipamentos){%>
                        <option><%=e.getFrota()%></option>    
                <%}%>  
              </select>
            </div>
            <div class="select-manut">
              <label for="motManutencao">Motorista</label>
              <select class="form-control" id="motManutencao" name="motManutencao" required>
                  <option value="" selected>Selecione um Motorista</option
                  <%
                    MotoristaDAO dao = new MotoristaDAO();
                    List<Motorista> motoristas = dao.retrieveAll();
                        for(Motorista m: motoristas){%>
                    <option><%=m.getNome()%></option>    
                <%}%>
              </select>
                         
            </div><br><br>
            <label for="descManutencao">Descrição do Serviço</label>
            <textarea class="form-control" rows="3" placeholder="Separe os serviços com vírgula" id="tipoServico" name="tipoServico"></textarea>
            <br>
            <label for="valorManutencao">Valor Total Manutenção</label>
              <input type="text" class="form-control" id="valorManutencao" name="valorManutencao" placeholder="Digite o valor total" required>
          </div>
          <div class="modal-footer">
            <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
            <button type="submit" class="btn btn-warning-mod" o>Cadastrar</button>
          </div>

        </form>
      </div>
      
    </div>
  </div>

  <!-- Modal Usuário -->
  <div class="modal fade modalp" id="modalUsuario" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
          <form action="ServletCadastrar" method="post" accept-charset="utf-8">

          <div class="modal-header modal-header-warning">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title" style="text-align: center;">Cadastro de Usuário</h4>
          </div>
          <div class="modal-body">
            <label for="placaEquipamento">Nome</label>
            <input type="text" class="form-control" id="nomeUser" name="nome" placeholder="Digite seu nome" required>
            <br>
            <label for="placaEquipamento">Usuário</label>
            <input type="text" class="form-control" id="loginUser" name="login" placeholder="Digite seu login" required>
            <br>
            <label for="modeloEquipamento">Senha</label>
            <input type="password" class="form-control" id="senhaUser" name="senha" placeholder="Digite sua senha " required>
            <br>
            <label for="modeloEquipamento">Confirmar Senha</label>
            <input type="password" class="form-control" id="rSenhaUser" placeholder="Repita a senha" required>
          </div>
          <div class="modal-footer">
            <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
            <button type="submit" class="btn btn-warning-mod" o>Cadastrar</button>
          </div>

        </form>
      </div>
      
    </div>
  </div>


  <span class="bfooter"></span>

    <script src="js/libs/jquery-1.11.2.min.js"></script>
    <script src="js/libs/jquery.mask.min.js"></script>
    <script src="js/libs/jquery.maskmoney.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
    
    <% 
        if (request.getParameter("sucess") != null){
            out.print("<script>alert('Cadastrado com Sucesso!!')</script>");
        }
        else if(request.getParameter("error") != null){
            out.print("<script>alert('Aconteceu algo, tente novamente!!')</script>");
        }
    %>
  </body>
</html>