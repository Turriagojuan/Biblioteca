
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% HttpSession obj = request.getSession();
if(obj != null && obj.getAttribute("usuario")!=null){

    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Principal</title>

    </head>
    <body>

        <h1>Mi Biblioteca</h1>
        <form action="ControCTO" method="post">
            <input type="hidden" name="menu" value="Libros">
            <input type="submit" name="accion" value="Listar">
        </form>

    </body>
</html>
<% }else{
                request.getRequestDispatcher("error.html").forward(request, response);

} %>