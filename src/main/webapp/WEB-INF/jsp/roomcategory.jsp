<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.lang.Integer"%>
<%@page import="com.hotel.Hotel_manager.entity.RoomCategory" %>
<%@page import="com.hotel.Hotel_manager.dto.NewRoomCategory" %>
<%@page import="com.hotel.Hotel_manager.service.RoomCategoryService" %>
<%@ page import="com.hotel.Hotel_manager.entity.Room" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.hotel.Hotel_manager.mapper.RoomCategoryMapper" %>
<%@ page import="com.hotel.Hotel_manager.repository.RoomCategoryRepository" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Room categories</title>
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
        .active > input, .active> button {
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
        .inactive{
            display: none;
        }
        .active{
            display: flex;
            flex-direction: column;
            padding: 0 40px 0 0;
            gap: 12px;
        }
        .boton-active{
            display: block;
        }
        .boton-inactive{
            display: none;
        }
    </style>
</head>
<body>
    <main>
        <div class="content">
            <h1>Modulo: categoria de habitaciones.</h1>

        </div>
        
        <div class="content" >
            <form action="${pageContext.request.contextPath}/roomcategories/save" method="post" class="${name==null ? 'active' : 'inactive'}">
                <p>Crea una nueva categoria </p>

                <input type="hidden" name="idCategoriaHabitacion" id="id" >
                <label for="nombre">Nombre</label>
                <input type="text" name="name" id="nombre" placeholder="Ingrese el nombre de la categoria" required>
                <label for="precio">Precio por noche:</label>
                <input type="number" name="price" id="precio" placeholder="Ingrese valor" required>
                <label for="url" >Enlace url de la foto:</label>
                <input type="url" name="url" id="url" placeholder="Ingrese url" required>
                <input type="hidden" name="accion" id="accion" value="enviarFormulario">
                <button type="submit" id="boton" name="boton"> Crear</button>

            </form>

            <div class="${name!=null ? 'boton-active' : 'boton-inactive'}" >
                <form action="true"  class="${name!=null ? 'active' : 'inactive'}" >
                    <p>Edita la categoria </p>
                    <input type="text" name="id" id="id" style="display: none;" required value="${id}">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="name" id="nombre" placeholder="Nombre" required value="${name}">
                    <label for="precio">Precio por noche:</label>
                    <input type="number" name="price" id="precio" placeholder="Precio noche" required value="${price}">
                    <label for="url" >Enlace url de la foto:</label>
                    <input type="url" name="url" id="url" placeholder="Url" value="${url}">
                    <button type="submit" id="boton" name="boton" > Editar Categoria</button>

                </form>
                <br>
                <form action="roomcategories" class="${name!=null ? 'active' : 'inactive'}">
                     <button type="submit"  style="padding: 8px;" > Cerrar edición y crear nueva categoria</button>
                </form>
            </div>




            <div class="listado">
                <div class="consulta"></div>

                <table>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio por noche</th>
                        <th>Url de la foto</th>
                        <th>Opciones</th>
                    </tr>

                    <c:forEach var="category" items="${roomCategories}">
                    <tr>
                        <td>${category.name}</td>
                        <td>${category.price}</td>
                        <td >
                            <a href=${category.url}>link</a>
                            <a href=${category.url}>
                                <img style="width: 100px"
                                        src="${category.url}"
                                        alt="Habitacion" />
                            </a>
                        </td>
                        <td>
                            <form id="myForm">
                                <input type="text" name="id" placeholder="ID" value="${category.id}" style="display: none">
                                <input type="text" name="name"  value="${category.name}" style="display: none">
                                <input type="number" name="price" value="${category.price}" style="display: none">
                                <input type="text" name="url" value="${category.url}"  style="display: none">
                                <button type="submit">Editar</button>
                            </form>


                            <script>
                                document.getElementById("editForm").addEventListener("submit", function(event) {
                                    event.preventDefault(); // Evita el envío predeterminado del formulario

                                    // Obtiene los valores de los campos del formulario
                                    const id = document.querySelector('input[name="id"]').value;
                                    const name = document.querySelector('input[name="name"]').value;
                                    const price = document.querySelector('input[name="price"]').value;
                                    const url = document.querySelector('input[name="url"]').value;

                                    // Realiza una solicitud fetch con headers personalizados
                                    fetch("<%= request.getContextPath() %>/roomcategories", {
                                        method: "GET",
                                        headers: {
                                            "Content-Type": "application/json",
                                            "id": id,
                                            "name": name,
                                            "price": price,
                                            "url": url
                                        }
                                    })
                                        .then(response => {
                                            if (!response.ok) {
                                                throw new Error("Error en la solicitud");
                                            }
                                            // Redirige a la página después de la solicitud exitosa
                                            window.location.href = "<%= request.getContextPath() %>/roomcategories";
                                        })
                                        .catch(error => {
                                            console.error("Error:", error);
                                            alert("Hubo un error al editar la categoría de habitación");
                                        });
                                });
                            </script>

</body>

                            <form action="${pageContext.request.contextPath}/roomcategories/delete?id=${category.id}" method="post">
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