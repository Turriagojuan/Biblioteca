<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
HttpSession obj = request.getSession();
if (obj != null && obj.getAttribute("usuario") != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <style>
            body {
                background-color: #e9ecef; /* Color de fondo gris claro */
                font-family: 'Arial', sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .container-fluid {
                background-color: #ffffff; /* Blanco */
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
            h1 {
                color: #007bff; /* Azul Bootstrap */
                font-size: 2.5rem;
                margin-bottom: 30px;
                font-weight: bold;
                text-align: center;
                border-bottom: 2px solid #007bff;
                padding-bottom: 10px;
            }
            .table-hover tbody tr:hover {
                background-color: #f1f1f1;
            }
            .table-dark {
                background-color: #343a40;
                color: #ffffff;
            }
            .table-dark th,
            .table-dark td {
                border-color: #454d55;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <h1>LIBRERÍA</h1>
            <table class="table table-hover table-dark">
                <thead>
                    <tr>
                        <th scope="col">ISBN</th>
                        <th scope="col">Nombre Libro</th>
                        <th scope="col">Autor</th>
                        <th scope="col">Editorial</th>
                        <th scope="col">Año</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="libro" items="${lista}">
                        <tr>
                            <td>${libro.getIsbn()}</td>
                            <td>${libro.getNombre()}</td>
                            <td>${libro.getAutor()}</td>
                            <td>${libro.getEditorial()}</td>
                            <td>${libro.getAnio()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    </body>
</html>
<% 
} else {
    request.getRequestDispatcher("error.html").forward(request, response);
} 
%>