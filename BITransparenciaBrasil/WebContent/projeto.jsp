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
    
    <style type="text/css">
			.active { display:inherit; }
			ul#map {display: block; margin: 0; padding: 0; width: 570px; height: 585px; background-image: url('img/map.gif');}
			ul#map li {display: block; padding: 0; position: absolute;}
			li#crs {margin-top: 485px; margin-left: 237px; }
			li#csc {margin-top: 467px; margin-left: 292px;}
			li#cpr {margin-top: 416px; margin-left: 281px;}
			li#csp {margin-top: 375px; margin-left: 303px; z-index:9999; }
			li#cms {margin-top: 336px; margin-left: 229px;}
			li#crj {margin-top: 390px; margin-left: 422px; z-index:9999; }
			li#ces {margin-top: 347px; margin-left: 467px; z-index:9999; }
			li#cmg {margin-top: 292px; margin-left: 333px; z-index:9998; }
			li#cgo {margin-top: 264px; margin-left: 301px; z-index:9999; }
			li#cdf {margin-top: 311px; margin-left: 373px; z-index:9999; }
			li#cba {margin-top: 207px; margin-left: 397px;}
			li#cmt {margin-top: 189px; margin-left: 180px;}
			li#cro {margin-top: 199px; margin-left: 104px; z-index:9998; }
			li#cac {margin-top: 185px; margin-left: 0px;}
			li#cam {margin-top: 46px; margin-left: 3px;}
			li#crr {margin-top: 0; margin-left: 133px;}
			li#cpa {margin-top: 40px; margin-left: 219px;}
			li#cap {margin-top: 13px; margin-left: 278px;}
			li#cma {margin-top: 94px; margin-left: 366px; z-index:9999;}
			li#cto {margin-top: 156px; margin-left: 338px;}

			li#cse {margin-top: 221px; margin-left: 519px; z-index:9998;}
			li#cal {margin-top: 211px; margin-left: 518px; z-index:9999;}
			li#cpe {margin-top: 188px; margin-left: 473px;}
			li#cpb {margin-top: 169px; margin-left: 511px; z-index:9999;}
			li#crn {margin-top: 151px; margin-left: 514px;}
			li#cce {margin-top: 121px; margin-left: 473px;}
			li#cpi {margin-top: 120px; margin-left: 406px; z-index:9997;}

			ul#map li a {display: block; text-decoration: none; position: absolute;}
			a#rs {width: 116px; height: 101px; }
			a#sc {width: 81px; height: 53px; }
			a#pr {width: 97px; height: 64px; }
			a#sp {width: 131px; height: 84px; }
			a#ms {width: 106px; height: 104px; }
			a#rj {width: 58px; height: 40px; }
			a#es {width: 33px; height: 51px; }
			a#mg {width: 163px; height: 131px; }
			a#go {width: 108px; height: 108px; }
			a#df {width: 16px; height: 9px; }
			a#ba {width: 136px; height: 148px; }
			a#mt {width: 166px; height: 161px; }
			a#ro {width: 104px; height: 87px; }
			a#ac {width: 108px; height: 62px; }
			a#am {width: 258px; height: 181px;}
			a#rr {width: 87px; height: 103px; }
			a#pa {width: 188px; height: 187px; }
			a#ap {width: 73px; height: 85px; }
			a#ma {width: 102px; height: 139px; }
			a#to {width: 74px; height: 125px; }
			a#se {width: 28px; height: 32px; }
			a#al {width: 46px; height: 27px; }
			a#pe {width: 97px; height: 34px; }
			a#pb {width: 59px; height: 35px; }
			a#rn {width: 53px; height: 33px; }
			a#ce {width: 61px; height: 76px; }
			a#pi {width: 83px; height: 124px; }

			/* Código pronto via http://css.spritegen.com (com alterações nos seletores) */

			a#pa:hover, a#pa:active, a#am:hover, a#am:active, a#mt:hover, a#mt:active, a#ba:hover, a#ba:active, a#ma:hover, a#ma:active,
			a#mg:hover, a#mg:active, a#to:hover, a#to:active, a#pi:hover, a#pi:active, a#go:hover, a#go:active, a#ms:hover, a#ms:active,
			a#rr:hover, a#rr:active, a#rs:hover, a#rs:active, a#ro:hover, a#ro:active, a#ap:hover, a#ap:active, a#sp:hover, a#sp:active,
			a#ce:hover, a#ce:active, a#pr:hover, a#pr:active, a#ac:hover, a#ac:active, a#sc:hover, a#sc:active, a#es:hover, a#es:active,
			a#rj:hover, a#rj:active, a#pb:hover, a#pb:active, a#pe:hover, a#pe:active, a#rn:hover, a#rn:active, a#se:hover, a#se:active,
			a#al:hover, a#al:active, a#df:hover, a#df:active
			{ display: block; background: url('img/sprite.gif') no-repeat; }

			a#pa:hover, a#pa:active { background-position: -10px -0px; width: 188px; height: 187px; }
			a#am:hover, a#am:active { background-position: -10px -197px; width: 258px; height: 181px; }
			a#mt:hover, a#mt:active { background-position: -10px -388px; width: 166px; height: 161px; }
			a#ba:hover, a#ba:active { background-position: -10px -559px; width: 136px; height: 148px; }
			a#ma:hover, a#ma:active { background-position: -156px -559px; width: 102px; height: 139px; }
			a#mg:hover, a#mg:active { background-position: -10px -717px; width: 163px; height: 131px; }
			a#to:hover, a#to:active { background-position: -183px -717px; width: 74px; height: 125px; }
			a#pi:hover, a#pi:active { background-position: -10px -858px; width: 83px; height: 124px; }
			a#go:hover, a#go:active { background-position: -103px -858px; width: 108px; height: 108px; }
			a#ms:hover, a#ms:active { background-position: -103px -976px; width: 106px; height: 104px; }
			a#rr:hover, a#rr:active { background-position: -10px -992px; width: 87px; height: 103px; }
			a#rs:hover, a#rs:active { background-position: -107px -1090px; width: 116px; height: 101px; }
			a#ro:hover, a#ro:active { background-position: -10px -1201px; width: 104px; height: 87px; }
			a#ap:hover, a#ap:active { background-position: -10px -1105px; width: 73px; height: 85px; }
			a#sp:hover, a#sp:active { background-position: -124px -1201px; width: 131px; height: 84px; }
			a#ce:hover, a#ce:active { background-position: -186px -388px; width: 61px; height: 76px; }
			a#pr:hover, a#pr:active { background-position: -124px -1295px; width: 97px; height: 64px; }
			a#ac:hover, a#ac:active { background-position: -10px -1298px; width: 108px; height: 62px; }
			a#sc:hover, a#sc:active { background-position: -128px -1369px; width: 81px; height: 53px; }
			a#es:hover, a#es:active { background-position: -208px -0px; width: 33px; height: 51px; }
			a#rj:hover, a#rj:active { background-position: -186px -474px; width: 58px; height: 40px; }
			a#pb:hover, a#pb:active { background-position: -10px -1370px; width: 59px; height: 35px; }
			a#pe:hover, a#pe:active { background-position: -10px -1415px; width: 97px; height: 34px; }
			a#rn:hover, a#rn:active { background-position: -186px -524px; width: 53px; height: 33px; }
			a#se:hover, a#se:active { background-position: -208px -61px; width: 28px; height: 32px; }
			a#al:hover, a#al:active { background-position: -208px -103px; width: 46px; height: 27px; }
			a#df:hover, a#df:active { background-position: -208px -140px; width: 16px; height: 9px; }

			/* Fim sprite */

			ul#map li a img {border: 0; width: inherit; height: inherit;}
		</style>
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0;">
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
    <section class="navigation">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2">
              <nav class="pull">
                <ul class="top-nav">
                  <li><a href="index.jsp">Home <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                  <li><a href="filtro.jsp">Análises <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                  <li><a href="projeto.jsp">Seleção Regional <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                  <li><a href="filtro-candidatos.jsp">Escolha de Cargos <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                 
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
                  <strong>Escolha o estado do seu candidato.</strong>
                  </h1>
                  <p style="margin-bottom:40px;"></p>  
            	</div>
           		<div class="col-md-12" align="center">
              		<ul id="map">
			<li id="crs" estado="rs"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=rs" id="rs" title="RS"><img src="img/null.gif" alt="RS" /></a></li>
			<li id="csc" estado="sc"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=sc" id="sc" title="SC"><img src="img/null.gif" alt="SC" /></a></li>
			<li id="cpr" estado="pr"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=pr" id="pr" title="PR"><img src="img/null.gif" alt="PR" /></a></li>
			<li id="csp" estado="sp"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=sp" id="sp" title="SP"><img src="img/null.gif" alt="SP" /></a></li>
			<li id="cms" estado="ms"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=ms" id="ms" title="MS"><img src="img/null.gif" alt="MS" /></a></li>
			<li id="crj" estado="rj"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=rj" id="rj" title="RJ"><img src="img/null.gif" alt="RJ" /></a></li>
			<li id="ces" estado="es"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=es" id="es" title="ES"><img src="img/null.gif" alt="ES" /></a></li>
			<li id="cmg" estado="mg"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=mg" id="mg" title="MG"><img src="img/null.gif" alt="MG" /></a></li>
			<li id="cgo" estado="go"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=go" id="go" title="GO"><img src="img/null.gif" alt="GO" /></a></li>
			<li id="cdf" estado="df"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=df" id="df" title="DF"><img src="img/null.gif" alt="DF" /></a></li>
			<li id="cba" estado="ba"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=ba" id="ba" title="BA"><img src="img/null.gif" alt="BA" /></a></li>
			<li id="cmt" estado="mt"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=mt" id="mt" title="MT"><img src="img/null.gif" alt="MT" /></a></li>
			<li id="cro" estado="ro"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=ro" id="ro" title="RO"><img src="img/null.gif" alt="RO" /></a></li>
			<li id="cac" estado="ac"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=ac" id="ac" title="AC"><img src="img/null.gif" alt="AC" /></a></li>
			<li id="cam" estado="am"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=am" id="am" title="AM"><img src="img/null.gif" alt="AM" /></a></li>
			<li id="crr" estado="rr"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=rr" id="rr" title="RR"><img src="img/null.gif" alt="RR" /></a></li>
			<li id="cpa" estado="pa"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=pa" id="pa" title="PA"><img src="img/null.gif" alt="PA" /></a></li>
			<li id="cap" estado="ap"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=ap" id="ap" title="AP"><img src="img/null.gif" alt="AP" /></a></li>
			<li id="cma" estado="ma"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=ma" id="ma" title="MA"><img src="img/null.gif" alt="MA" /></a></li>
			<li id="cto" estado="to"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=to" id="to" title="TO"><img src="img/null.gif" alt="TO" /></a></li>
			<li id="cse" estado="se"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=se" id="se" title="SE"><img src="img/null.gif" alt="SE" /></a></li>
			<li id="cal" estado="al"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=al" id="al" title="AL"><img src="img/null.gif" alt="AL" /></a></li>
			<li id="cpe" estado="pe"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=pe" id="pe" title="PE"><img src="img/null.gif" alt="PE" /></a></li>
			<li id="cpb" estado="pb"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=pb" id="pb" title="PB"><img src="img/null.gif" alt="PB" /></a></li>
			<li id="crn" estado="rn"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=rn" id="rn" title="RN"><img src="img/null.gif" alt="RN" /></a></li>
			<li id="cce" estado="ce"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=ce" id="ce" title="CE"><img src="img/null.gif" alt="CE" /></a></li>
			<li id="cpi" estado="pi"><a href="resultado-dos-candidatos.jsp?cargo=<%=request.getParameter("cargo")%>&estado=pi" id="pi" title="PI"><img src="img/null.gif" alt="PI" /></a></li>
		</ul>
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