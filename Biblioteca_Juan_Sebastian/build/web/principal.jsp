
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
        <style>
            body {
                background-color: #f0f0f0; /* Blanco claro */
                font-family: Arial, sans-serif;
            }
            .container {
                max-width: 800px;
                margin: 40px auto;
                padding: 20px;
                background-color: #fff; /* Blanco */
                border: 1px solid #ddd; /* Gris claro */
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            input[type="text"],  input[type="number"]{
                width: 100%;
                padding: 5px;
                box-sizing: border-box; /* Include padding in width */
            }
            .form-group {
                margin-bottom: 20px;
            }
            .form-control {
                width: 100%;
                height: 40px;
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc; /* Gris claro */
            }
            .btn {
                background-color: #333; /* Negro */
                color: #fff; /* Blanco */
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
            .btn:hover {
                background-color: #444; /* Gris oscuro */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Bienvenido a la Biblioteca</h1>
            <form action="ControCTO" method="post">
                <div class="form-group">
                    <label for="isbn">ISBN:</label>
                    <input type="text" class="form-control" id="isbn" name="isbn" >
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" >
                </div>
                <div class="form-group">
                    <label for="autor">Autor:</label>
                    <input type="text" class="form-control" id="autor" name="autor" >
                </div>
                <div class="form-group">
                    <label for="editorial">Editorial:</label>
                    <input type="text" class="form-control" id="editorial" name="editorial" >
                </div>
                <div class="form-group">
                    <label for="anio">Año:</label>
                    <input type="number" class="form-control" id="anio" name="anio" >
                </div>
                <div class="form-group">
                    <input type="submit" name="accion" value="Listar" class="btn">
                    <input type="submit" name="accion" value="Agregar" class="btn">
                    <input type="submit" name="accion" value="Actualizar" class="btn">
                    <input type="submit" name="accion" value="Eliminar" class="btn">
                    <input type="submit" name="accion" value="Buscar" class="btn">
                    <input type="submit" name="accion" value="Salir" class="btn">
                </div>
            </form>
        </div>
    </body>
</html>
<% }else{
                request.getRequestDispatcher("error.html").forward(request, response);

} %>