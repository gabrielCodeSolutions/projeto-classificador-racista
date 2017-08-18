

<%@page import="java.util.List"%>
<%@page import="Model.Usuario"%>
<%@page import="Control.DaoUsuario"%>
<%@page import="Control.DaoTexto"%>

<html>
    <head>
        <link href="assets/expand.css" rel="stylesheet" type="text/css"/>
        <script src="assets/expand.js" type="text/javascript"></script>
        
        <link href="assets/bootstrap.css" rel="stylesheet" type="text/css"/>
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
        
      <div class="container">
    <div class="row">
        <div class="col-md-12">	
    
			<div class="panel panel-primary">
            
    			<div class="panel-heading">
                    <h3 class="panel-title">
				        Usuarios validaram mais posts :)
                    </h3>
                    <span class="pull-right btn-click">
                        <i class="fa fa-chevron-circle-up"></i>
                    </span> 
				</div>
                
			<div class="clearfix"></div>
            
			<div class="panel-body">
							
    			<table class="table table-condensed">
                    <thead>
                        <tr>
                            <th>Usuário</th>
                            <th>Posts Validados / Total  (<%=new DaoTexto().getStatus()%>)</th>  
                        </tr>
                    </thead>
                    <tbody>
                        <% DaoUsuario du = new DaoUsuario();
                           List<Usuario> lista = du.ListarTodos();
                           
                           for(Usuario u : lista)
                           {%>
                            <tr>
                                <td><%=u.getLogin()%></td>
                                <td><%=u.getQtd_validacoes()%></td>
                            </tr>
                           <%}%>
                           
                    </tbody>
                </table>
																
		</div>
                
	</div>
</div>
        </div>
        </div>
    </body>
</html>