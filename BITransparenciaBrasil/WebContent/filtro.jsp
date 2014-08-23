<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
  String path = request.getContextPath();
%> 

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
  <head>
    <meta equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sinn Tecnologia - Hackathon Transparência Brasil</title>
    
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/flexslider.css" type="text/css">
    <link href="css/flat-ui" rel="stylesheet">
    <link href="css/styles.css?v=1.6" rel="stylesheet">
    <link href="css/queries.css?v=1.6" rel="stylesheet">
    <link href="css/jquery.fancybox.css" rel="stylesheet">
    <link rel="shortcut icon" href="img/favicon.png">
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
      <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
    </head>
    <body>
      <section class="navigation">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2">
              <nav class="pull">
                <ul class="top-nav">
                  <li><a href="index.jsp">Home <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                 
                  <!--<li class="nav-last"><a href="#design">Design <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>-->
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </section>
      <section class="projeto" id="projeto" style="height:300px;">
        <div class="container">
          <div class="row">
            <div class="col-md-12 text-right">
              <a href="#"><i class="fa fa-navicon fa-2x nav_slide_button"></i></a>
            </div>
          </div>
          <div class="row">
            <div class="col-md-8 col-md-offset-2 text-center">
              <img src="img/logo.png" style="alignment-adjust:central; margin-bottom:5px; width:125px;">
              <h1 class="animated bounceInDown" style="color:#FFFFFF;"><strong>Transparência Brasil</strong></h1>
            </div>
          </div>
        </div>
      </section>
      
      <section class="features" id="tecnologia">
        <div class="container">
          <div class="row">
			
            	<div class="col-md-8 col-md-offset-2" align="center">
                  <h1 style="color:#666; font-size:24px;">
                  <strong>Painéis de análise</strong>
                  </h1>
                  <p style="margin-bottom:40px;">Escolha do tipo de análise, consultas livres ou painéis analíticos dos candidatos.</p>  
            	</div>
            
	            <div class="col-md-4 features-rightcol wp3">
	              <a href="filtro-candidatos.jsp"><img src="img/btn_candidato.jpg" alt="Painel dos Candidatos" title="Painel dos Candidatos"></a>             
	            </div>
	            <div class="col-md-4 features-rightcol wp3">
	              <a href="dashboard.jsp"><img src="img/btn_consulta.jpg" alt="Painel de Consulta" title="Painel de Consulta"></a>
	            </div>
	            <div class="col-md-4 features-rightcol wp3">
	              <a href="estatisticas.jsp"><img src="img/btn_estatisticas.jpg" alt="Estatísticas Gerais" title="Estatísticas Gerais"></a>
	            </div>
          </div>
          
        </div>
      </section>     
      
  
      <footer>
        <div class="container">
          <div class="row">
            <div class="col-md-4">
              <p>Há quatro anos no mercado, somos uma empresa de tecnologia especializada em soluções empresariais e consultoria, atuando no segmento de desenvolvimento e implantação de sistemas.
              <br>Atualmente, o nosso diferencial é o desenvolvimento e implantação de soluções de inteligência de negócios, oferecendo ao cliente ferramentas que ajudem a melhorar o processo de tomada de decisão. Totalmente alinhados com atividades de Pesquisa & Desenvolvimento, orgulhamo-nos em ser uma empresa nativa Coppe/UFRJ.</p>
            </div>
            <div class="col-md-3">
              <h1 style="color:#FFF;">Entre em contato</h1>
              <p>Av. Passos, 122, Sala 806<br>
              Centro - Rio de Janeiro, RJ<br>
              CEP.: 20051-040<br>
              Telefone: (+55 21) 3559-0665 / 3549-0465<br>
              Escritório São Paulo: (+5511) 3230-6659<br>
              Escritório Brasília: (+5561) 4042-0665<br>
              Email: contato@sinn.com.br</p>
            </div>
            
          </div>
          <div class="row">
            <div class="col-md-12 text-center">
              <a href="#" class="badge-btn">Badge Button</a>
              <p class="footer-credit">Desenvolvido por <a href="http://www.sinn.com.br">Sinn Tecnologia</a></p>
              <img src="img/hackathon.png" style="width:400px; margin-top:25px;">
            </div>
          </div>
        </div>
      </footer>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
      <script src="js/jquery.fancybox.pack.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="js/bootstrap.min.js"></script>
      <script src="js/scripts.js?v=1.7"></script>
      <script src="js/jquery.flexslider.js"></script>
      <script src="js/jquery.smooth-scroll.js"></script>
      <script src="js/modernizr.js"></script>
      <script src="js/waypoints.min.js"></script>
    </body>
  </html>