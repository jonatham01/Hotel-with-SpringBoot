<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.lang.Integer"%>
<%@page import="com.hotel.Hotel_manager.entity.Room" %>
<%@page import="com.hotel.Hotel_manager.dto.NewRoom" %>
<%@page import="com.hotel.Hotel_manager.service.RoomService" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.hotel.Hotel_manager.entity.RoomCategory" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Rooms</title>
    <style>
        main{
            display: flex;
            align-items: center;
            flex-direction: column;
            column-gap: 0px;
            gap: 0px;
        }
        .content{
            margin: 0;
            padding: 0;
            width: 1024px;
            display: grid;
            grid-template-columns: repeat(2, 50% [col-start]);
            gap: 40px;
        }
        form{
            display: flex;
            flex-direction: column;
            padding: 0 40px 0 0;
            gap: 12px;
        }
        form > input, form > button {
            padding: 8px;
        }
        table{
            width: 100%;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td{
            padding: 8px 28px;
        }
    </style>
</head>
<body>
<main>
    <div class="content">
        <h1>Modulo: Habitaciones.</h1>
    </div>

    <div class="content">
        <form action= "${pageContext.request.contextPath}/room/save" method="post">
            <input type="hidden" name="idHabitacion" id="id" >
            <label for="piso">piso</label>
            <input type="number" name="piso" id="piso" placeholder="Ingrese piso de la habitación" required>
            <label for="contacto">Número de contacto:</label>
            <input type="number" name="contacto" id="contacto" placeholder="Ingrese número de contacto" required>
            <label for="categoria" >Categoria:</label>
            <select  name="categoria" id="categoria">
                 <c:forEach var="category" items="${categories}">
                    <option value=${category.id}> ${category.name} -$ ${category.price} </option>
                 </c:forEach>
            </select>
            <button type="submit" id="boton" name="boton"> Crear</button>
        </form>

        <div class="listado">
            <div class="consulta"></div>

            <table>
                <tr>
                    <th>Piso</th>
                    <th># Contacto</th>
                    <th>Categoria</th>
                    <th>Modificar</th>
                </tr>

                <c:forEach >
                    <tr>
                        <td> ${room.floorNumber} </td>
                        <td> ${room.contactNumber} </td>
                        <td> ${room.category.name} </td>
                        <td>
                            <form  id="editForm">
                                <input type="number" name="id" value="${room.id}" style="display: none">
                                <button type="submit">Editar</button>
                            </form>

                            <form action="${pageContext.request.contextPath}/room/delete?id=${room.id}" method="post">
                                <button type="submit">Borrar</button>
                            </form>
                        </td>

                    </tr>

                </c:forEach>



            </table>
        </div>

    </div>
</main>


</body>
</html>