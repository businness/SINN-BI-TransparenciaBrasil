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
                  <li><a href="#nossaproposta">Nossa Proposta <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                  <li><a href="#equipe">Equipe <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                  <li><a href="#tecnologia">Tecnologia <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>
                  <!--<li class="nav-last"><a href="#design">Design <span class="indicator"><i class="fa fa-angle-right"></i></span></a></li>-->
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </section>
      <section class="hero" id="hero">
        <div class="container">
          <div class="row">
            <div class="col-md-12 text-right">
              <a href="#"><i class="fa fa-navicon fa-2x nav_slide_button"></i></a>
            </div>
          </div>
          <div class="row">
            <div class="col-md-8 col-md-offset-2 text-center">
              <img src="img/logo.png" style="alignment-adjust:central; margin-bottom:5px; width:125px;">
              <h1 class="animated bounceInDown"><strong>Transparência Brasil</strong></h1>
              <p class="animated fadeInUpDelay"><strong>O que queremos oferecer é uma plataforma que possa dar respostas a qualquer um que tenha perguntas!</strong><br><br><br></p>
            </div>
          </div>
          <!--<div class="row">
            <div class="col-md-2 col-md-offset-5 text-center">
            <a href="http://bcove.me/fkgald9b" class="hero-play-btn various fancybox.iframe">Play Button</a>
            </div>
          </div>-->
          <div class="row">
            <div class="col-md-6 col-md-offset-3 text-center">
              <a href="filtro.jsp" class="get-started-btn">Acesso ao Projeto</a>
            </div>
          </div>
        </div>
      </section>
      <section class="download-now" id="nossaproposta">
        <div class="container">
          <div class="row">
            <div class="col-md-8 wp1">
              <h1>
              Implantação de um BI usando os dados fornecidos pela API do Transparência Brasil
              </h1>
              <p>Como engine de BI usaremos o Pentaho, um BI Open Source com código livremente disponível (GPLv2). Seriam desenvolvidos durante o Hackathon os processos de ETL para a carga de dados da API, o modelo estrela no banco de dados, a modelagem dos cubos OLAP, bem como algumas consultas ad-hoc pré-definidas e, eventualmente, dashboards que possam mostrar dados interessantes sobre os candidatos. 
				<br><br>Sobrando tempo, seria possível ainda integrar o fluxo de carga de dados (ETL) ao Weka (outro software open source), responsável por fazer Data Minning. Poderíamos aplicar alguns algoritmos de clustering e tentar encontrar relacionamentos improváveis.
                <br><br>Uma vez feito esse processamento de carga, tudo seria carregado em um SGBD (open source, com certeza!) num modelo estrela. Depois, seria necessário fazer um cubo OLAP e publicar esse cubo na plataforma Pentaho. Uma vez publicado e tornado público, qualquer usuário interessado poderia fazer suas próprias consultas através de uma interface adhoc, encontrando informações estatística de qualquer candidato. Poderiam ser medidos, por exemplo, quantas vezes cada um já concorreu, quantas vezes se elegeu, o impacto da eleição na evolução patrimonial de cada candidato, quais candidatos mais "rentáveis" em relação a numero de votos recebidos, doações recebidas e a relação entre estas, etc. Enfim, as possibilidades são imensas e vão depender única e esclusivamente da criatividade do usuário da ferramenta, que pode ser qualquer pessoa com acesso à web!
                <br><br>Em resumo, o que queremos oferecer não são respostas, mas uma plataforma que possa dar respostas a qualquer um que tenha perguntas!"</p>
              <a href="filtro.jsp" class="download-btn">Acessar Projeto</a>
            </div>
          </div>
        </div>
      </section>
      <section class="testimonials" id="equipe">
        <div class="container">
          <div class="row">
            <div class="col-md-12 text-center">
              <div id="firstSlider">
                <ul class="slides">
                  <li>
                    <div class="avatar"><img src="img/av-fabio.png" alt="Fabio Marzullo"></div>
                    <h1>Doutor pela COPPE/UFRJ, com 18 anos de experiência em desenvolvimento de soluções de TI e empresário há mais de 10 anos, tem atuado ao longo dos últimos 4 anos no desenvolvimento e implantação de soluções de Business Intelligence para órgãos públicos e empresas privadas.</h1>
                  </li>
                  <li>
                    <div class="avatar"><img src="img/av-rodrigo.png" alt="Rodrigo Porto"></div>
                    <h1>Cientista de dados certificado pela Pentaho, atua como gerente de projetos e TI, desenvolvedor DW com ampla experiência nacional e internacional, é um profissional Pentaho certified.</h1>
                  </li>
                  <li>
                    <div class="avatar"><img src="img/av-cesar.png" alt="Cesar Marzullo"></div>
                    <h1>Formado em Administração com Ênfase em Análise de Sistemas, possui 16 anos de experiência entre edição de imagens e design para plataformas web, mobile e gráfica.</h1>
                  </li>
                  <li>
                    <div class="avatar"><img src="img/av-morley.png" alt="Leonardo Morley"></div>
                    <h1>Formado em TI pela UERJ, com MBA em Engenharia de Computação Avançada pela UFRJ, possui mais de 18 anos de experiência na industria de TI, certificado como PMP, PMI-RMP e CSM, com uma sólida experiência em gestão de projetos e mais de 12 anos em arquitetura corporativa, arquitetura de soluções e desenvolvimento de software.</h1>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section class="features" id="tecnologia">
        <div class="container">
          <div class="row">
            
            <div class="col-md-12 text-center">
            <img src="img/diagrama-de-entendimento.jpg">
            </div>
            <div class="col-md-6 features-leftcol wp2">
              <h1>Ad Hoc</h1>
              <p class="margin-bottom">Em engenharia de software, a expressão ad hoc é utilizada para designar ciclos completos de construção de softwares que não foram devidamente projectados em razão da necessidade de atender a uma demanda específica do usuário, ligada a prazo, qualidade ou custo. Modelos informais utilizados pelo desenvolvedor de software costumam ser ad hoc, como rabiscar uma idéia para obter maior clareza e simplificação da realidade. Porém, esses modelos não oferecem uma linguagem básica que possa ser compartilhada com outras pessoas facilmente.</p>
              <h1>Processos de ETL</h1>
              <p>Extract Transform Load (Extração Transformação Carga), são ferramentas de software cuja função é a extração de dados de diversos sistemas, transformação desses dados conforme regras de negócios e por fim a carga dos dados geralmente em um Data Mart e um Data Warehouse, porém nada impede que também seja para enviar os dados para um determinado sistema da organização.</p>
            </div>
            <div class="col-md-6 features-rightcol wp3">
              <h1>Big Data e Data Mining</h1>
              <p class="margin-bottom">Refere-se a um grande armazenamento de dados e maior velocidade. Diz-se que o Big Data se baseia em 5 "V" : velocidade, volume, variedade, veracidade e valor. O uso do Big Data pode ser uma arma contra os problemas socioeconômicos. Data mining é o processo de explorar grandes quantidades de dados à procura de padrões consistentes, como regras de associação ou sequências temporais, para detectar relacionamentos sistemáticos entre variáveis, detectando assim novos subconjuntos de dados.</p>
              <h1>Cubos OLAP</h1>
              <p>"Online analytical processing", ou OLAP fornece para organizações um método de acessar, visualizar, e analisar os dados corporativos com alta flexibilidade e performance. No mundo globalizado de hoje as empresas estão enfrentando maior concorrência e expandindo sua atuação para novos mercados. Portanto, a velocidade com que executivos obtêm informações e tomam decisões determina a competitividade de uma empresa e seu sucesso de longo prazo.</p>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 text-center">
              <a href="http://sinn.com.br/pentaho.jsp" class="try-btn">Conheça o Pentaho</a>
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
            <div class="col-md-2 col-md-offset-3">
              <ul class="footer-nav">
                <li><a href="#nossaproposta">Nossa Proposta</a></li>
                <li><a href="#equipe">Equipe</a></li>
                <li><a href="#tecnologia">Tecnologia</a></li>

              </ul>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 text-center">
              <h2 style="color:#FFFFFF"><strong>Fontes de dados utilizadas</strong></h2>
              <p><a href="http://dev.transparencia.org.br/api-portal/" target="_blank" style="text-decoration:none;">Transparência Brasil - API aberta</a></p>
              <p><a href="http://downloads.ibge.gov.br/downloads_estatisticas.htm" target="_blank" style="text-decoration:none;">IBGE - PIB Ano</a></p>
              <p><a href="http://www.bndes.gov.br/SiteBNDES/bndes/bndes_pt/Institucional/BNDES_Transparente/Consulta_as_operacoes_do_BNDES/operacoes_diretas_e_indiretas_nao_automaticas.html" target="_blank" style="text-decoration:none; margin-bottom:45px;">BNDES - Operações diretas e indiretas não automáticas</a></p>
            </div>
            
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