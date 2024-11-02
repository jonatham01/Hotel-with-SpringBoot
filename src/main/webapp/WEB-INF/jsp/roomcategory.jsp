<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.lang.Integer"%>
<%@page import="com.hotel.Hotel_manager.entity.RoomCategory" %>
<%@page import="com.hotel.Hotel_manager.dto.NewRoomCategory" %>
<%@page import="com.hotel.Hotel_manager.service.RoomCategoryService" %>
<%@ page import="com.hotel.Hotel_manager.entity.Room" %>
<%@ page import="java.util.Optional" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Room Categories</title>
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
            <h1>Modulo: categoria de habitaciones.</h1>
        </div>
        
        <div class="content">
            <form action="">
                <input type="hidden" name="idCategoriaHabitacion" id="id" >
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre" placeholder="Ingrese el nombre de la categoria" required>
                <label for="precio">Precio por noche:</label>
                <input type="number" name="precio" id="precio" placeholder="Ingrese valor" required>
                <label for="url" >Enlace url de la foto:</label>
                <input type="url" name="url" id="url" placeholder="Ingrese url" required>
                <input type="hidden" name="accion" id="accion" value="enviarFormulario">
                <button type="submit" id="boton" name="boton"> Crear</button>
            </form>
            <%
                String idCategoriaParam = request.getParameter("idCategoriaHabitacion");
                int idEditar = -1;
                if( idCategoriaParam != null  && !idCategoriaParam.isEmpty()){
                    idEditar = Integer.parseInt(request.getParameter("idCategoriaHabitacion"));
                }
                String nombre = request.getParameter("nombre");
                String fotoUrl = request.getParameter("url");
                String accion = request.getParameter("accion");
                if ("enviarFormulario".equals(accion)) {
                    if (nombre != null && request.getParameter("precio") != null && fotoUrl != null){
                        double precio = Double.parseDouble(request.getParameter("precio"));
                        RoomCategoryService servicio = new RoomCategoryService();
                        servicio.save(new NewRoomCategory(nombre,precio,fotoUrl));
                        out.println("<script>");
                        out.println("document.getElementById('nombre').value = '';");
                        out.println("document.getElementById('precio').value = '';");
                        out.println("document.getElementById('url').value = '';");
                        out.println("document.getElementById('accion').value = 'enviarFormulario';");
                        out.println("</script>");
                    }
                }
                else if("editarFormulario".equals(accion) && idEditar  != -1){

                    if (nombre != null && request.getParameter("precio") != null && fotoUrl != null){
                        double precio = Double.parseDouble(request.getParameter("precio"));
                        RoomCategoryService servicio = new RoomCategoryService();
                        Optional<RoomCategory> newCategory = servicio.update(new NewRoomCategory(nombre,precio,fotoUrl), idEditar);
                       if(newCategory.isPresent()){
                           out.println("<script>");
                           out.println("document.getElementById('nombre').value = '';");
                           out.println("document.getElementById('precio').value = '';");
                           out.println("document.getElementById('url').value = '';");
                           out.println("document.getElementById('accion').value = 'enviarFormulario';");
                           out.println("</script>");
                       }
                    }
                }
            %>

            <div class="listado">
                <div class="consulta"></div>

                <table>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio por noche</th>
                        <th>Url de la foto</th>
                        <th>Modificar</th>
                    </tr>
                    <%
                        RoomCategoryService servicio = new RoomCategoryService();
                        List<RoomCategory> listado = servicio.getAll();
                        if (listado == null) {
                            out.println("<tr><td>------------</td><td>------------</td><td>------------</td><td>------------</td></tr>");
                        } else {
                            for (RoomCategory data : listado) {
                    %>
                    <tr>
                        <td><%= data.getName() %></td>
                        <td><%= data.getPrice() %></td>
                        <td><%= data.getUrl() %></td>
                        <td>
                            <form action="">
                                <input type="hidden" name=<%= data.getId() %> value="enviarFormulario">
                                <button type="submit">Editar</button>
                                <%
                                    String accionEditar;
                                    accionEditar = request.getParameter(String.valueOf(data.getId()));

                                    if ("enviarFormulario".equals(accionEditar)) {

                                        RoomCategory itemEditar = servicio.getById(data.getId());
                                        if (itemEditar != null) {

                                            // Asignar valores de la categoría a los campos del formulario
                                            int id = itemEditar.getId();
                                            String nombreEditar = itemEditar.getName();
                                            double precioEditar = itemEditar.getPrice();
                                            String fotoUrlEditar = itemEditar.getUrl();


                                            // Cargar los datos en el formulario
                                            out.println("<script>");
                                            out.println("document.getElementById('nombre').value = '" + nombreEditar + "';");
                                            out.println("document.getElementById('precio').value = '" + precioEditar + "';");
                                            out.println("document.getElementById('url').value = '" + fotoUrlEditar + "';");
                                            //out.println("document.getElementById('boton').textContent = '" + "editar / crear" + "';");
                                            out.println("document.getElementsByName('accion')[0].value = 'editarFormulario';");
                                            out.println("document.getElementsByName('idCategoriaHabitacion')[0].value = " + id + ";");

                                            out.println("</script>");
                                            //out.println("<p>" + id + "</p>");

                                        }

                                    }

                                %>
                            </form>

                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>

                </table>
            </div>

        </div>
    </main>


</body>
</html>