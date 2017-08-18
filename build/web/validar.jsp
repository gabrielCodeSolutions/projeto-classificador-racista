

<%@page import="Model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Model.Texto"%>
<%@page import="Control.DaoTexto"%>
<%@page import="Control.DaoUsuario"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<!DOCTYPE html>
<link href="assets/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="assets/shadow.css" rel="stylesheet" type="text/css"/>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Dosis|Special+Elite" rel="stylesheet">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 
 <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<html>
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validar</title>     
        
        <script>
        $(document).ready(function(){
            $(".esconde").click(function(){
                $("experimental").hide('slow'); 
            });
            $(".mostra").click(function(){
                $("experimental").show('slow');
            });
        });
        </script>
    </head>
    <body>
        <%HttpSession sessao = request.getSession();
        if(sessao.getAttribute("id") == null)
        {
          sessao.setAttribute("id",1);
          sessao.setAttribute("login","Anônimo");     
        } else
        {
            sessao.setAttribute("login", new DaoUsuario().GetNome((int)sessao.getAttribute("id")));
        }%>
        
        <%@include file="../WEB-INF/NavBar.jspf" %>
    
       <% List<Texto> lista = new DaoTexto().ListarTodos();%>
           
       
       
       
        <div class="container">
        <div class="col-md-12">
            <% for (Texto t : lista)
            {%>
                
                <div class="container">
                    <div class="row">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="fa fa-times"></i></button>
                            <h4 class="modal-title">Post: <%=t.getId()%> </h4>
                            
                        </div>
                        <form method="post" action="${pageContext.request.contextPath}/ValidarTexto">
                            <div class="modal-body">
                                <div class="form-group">
                                    <p style="font-family: 'Arial', cursive;"><font size="6">"</font><font size="3"> <%=t.getTexto()%> </font> <font size="6">"</font> </p>
                                    <input type="hidden" name="id_texto" value="<%=t.getId()%>">
                                </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="form-group">
                                                    <div data-toggle="buttons">
                                                        <b> O texto acima é relevante para a pesquisa (analisar textos racistas)?  </b><br />
                                                      <label class="btn btn-default btn-circle btn-lg mostra">       <input type="radio" name="opiniao" value="S"><i style="color: green;" class="glyphicon glyphicon-ok" required></i></label>
                                                      <label class="btn btn-default btn-circle btn-lg esconde">       <input type="radio" name="opiniao" value="N"><i style="color: red;" class="glyphicon glyphicon-remove"required></i></label>
                                                    </div>
                                                </div>
                                                <experimental>
                                                <div class="form-group">
                                                    <div data-toggle="buttons">
                                                        <b> Ele apresenta um teor/conteúdo racista?</b><br />
                                                        <label class="btn btn-default btn-circle btn-lg">       <input type="radio" name="racista" value="S"><i style="color: green;" class="glyphicon glyphicon-ok"required></i></label>
                                                      <label class="btn btn-default btn-circle btn-lg">       <input type="radio" name="racista" value="N"><i style="color: red;" class="glyphicon glyphicon-remove"required></i></label>
                                                    </div>
                                                </div>
                                                </experimental>
                                            </div>
                                        </div>                                        
                                    </div>
                            </div>
                            <div class="modal-footer">
                                
                                    <input type="hidden" name="isEmpty" value="">
                                    <button type="input" style= "float:left;" class="btn btn-success btn-icon"><i  class="fa fa-check"></i> Avaliar</button>
                                    <a href='validar.jsp' style= "float:left; margin-left:4%" class="btn btn-warning btn-icon"><i  class="fa fa-check"> Não sei</a>
                                    <%if(request.getParameter("erro") != null && request.getParameter("erro").equals("0")) 
                                      {%>
                               <label style="color: red;">Se você quer validar um post, deve responder pelo menos à primeira pergunta!</label>  <%}%>
                               <%if(request.getParameter("erro") != null && request.getParameter("erro").equals("1")) 
                                      {%>
                               <label style="color: red;">Se você marcou sim na primeira pergunta, também deve  responder à segunda!</label>  <%}%>
                            </div>
                        </form>
                    </div>
                    </div>
                </div>           
            <hr>         
            <%}%>  <!-- WHILE END -->
        </div>      
        </div>    
    </body>
</html>
