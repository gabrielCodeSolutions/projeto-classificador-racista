<html>
    <link href="assets/bootstrap.css" rel="stylesheet" type="text/css"/>
    <link href="assets/entrar.css" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lana2</title>
    </head>
    <body>
         <%HttpSession sessao = request.getSession();
        if(sessao.getAttribute("id") == null)
        {
          sessao.setAttribute("id",1);
            sessao.setAttribute("login","An�nimo");
        }%>
 <%@include file="../WEB-INF/NavBar.jspf" %>
        <div class="container">
            <div class="row login">
                <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 well">
                    <form role="form" method="post" action="${pageContext.request.contextPath}/Login">
                        <div class="form-group text-center" style="font-family: 'Dosis', sans-serif;">
                        <div class="logo">
                            <h3>Bem vindo ao classificador de textos do projeto</h3>
                                <h1> Lana 2 </h1><br /><h4 style="text-align: left;">Entre com seu usuario ou digite um novo usuario e senha para se cadastrar</h4>
                        </div>
                      </div>
                      <div class="form-group">
                          <%
                              if(request.getParameter("erro") != null && request.getParameter("erro").equals("1")) 
                            {%>
                              <label style="color: red;">Usu�rio ou Senha incorretos</label>
                            <%}%>
                            <%if(request.getParameter("erro") != null && request.getParameter("erro").equals("0")) 
                            {%>
                               <label style="color: red;">Este usu�rio j� est� em uso</label>  
                            <%}%>
                            <%if(request.getParameter("erro") != null && request.getParameter("erro").equals("3")) 
                            {%>
                               <label style="color: red;">J� t� querendo bugar o sistema, crie um usu�rio que tenha um login e uma senha</label>  
                            <%}%>
                        <input type="text" class="form-control input-lg" id="userid" name="login" placeholder="Digite seu usuario">
                      </div>
                      <div class="form-group">
                        <input type="password" class="form-control input-lg" id="password" name="senha" placeholder="Digite sua senha">
                      </div>
                      <div class="form-group">
                        <button type="submit" name="botao" value="entrar" class="btn btn-default btn-lg btn-block btn-success">Entrar</button><br />
                         <button type="submit" name="botao" value="cadastrar" class="btn btn-default btn-lg btn-block btn-default">Cadastrar e Entrar</button>
                        
                      </div>
                      <div class="form-group last-row">
                        
                        <a href="validar.jsp" class="pull-right">Entrar An�nimo</a>
                        <%if(request.getParameter("erro") != null ) 
                            {%>
                            <label style="color: #eea236;">Voc� n�o precisa ter um login pra acessar o sistema, pode entrar an�nimo se quiser, clicando <a href="validar.jsp">aqui</a></label>  
                            <%}%>
                      </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>