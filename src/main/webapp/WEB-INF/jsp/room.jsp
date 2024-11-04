<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="java.lang.Integer"%>
<%@page import="com.hotel.Hotel_manager.entity.Room" %>
<%@page import="com.hotel.Hotel_manager.dto.NewRoom" %>
<%@page import="com.hotel.Hotel_manager.service.RoomService" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.hotel.Hotel_manager.mapper.RoomMapper" %>
<%@ page import="com.hotel.Hotel_manager.repository.RoomRepository" %>
<%@ page import="com.hotel.Hotel_manager.service.RoomCategoryService" %>
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
        <form action="">
            <input type="hidden" name="idHabitacion" id="id" >

            <label for="piso">piso</label>
            <input type="number" name="piso" id="piso" placeholder="Ingrese piso de la habitación" required>

            <label for="contacto">Número de contacto:</label>
            <input type="number" name="contacto" id="contacto" placeholder="Ingrese número de contacto" required>

            <label for="categoria" >Categoria:</label>
            <select  name="categoria" id="categoria">
                <%
                    RoomCategoryService servicioCategory = new RoomCategoryService();
                    List<RoomCategory> categoriasDisponibles = servicioCategory.getAll();
                    for (RoomCategory cat : categoriasDisponibles) {

                %>
                    <option value=<%= cat.getId() %>> <%= cat.getName() %> - <%= cat.getPrice() %> </option>
                <%
                    }
                %>

            </select>

            <input type="hidden" name="accion" id="accion" value="enviarFormulario">
            <button type="submit" id="boton" name="boton"> Crear</button>
        </form>
        <%
            RoomService servicio = new RoomService();
            String idParam = request.getParameter("idHabitacion");
            int idEditar = -1;
            if( idParam != null  && !idParam.isEmpty()){
                idEditar = Integer.parseInt(idParam);
            }


            String accion = request.getParameter("accion");
            if ("enviarFormulario".equals(accion)) {
                if (request.getParameter("piso") != null && request.getParameter("contacto") != null && request.getParameter("categoria") != null){
                    int piso = Integer.parseInt(request.getParameter("piso"));
                    int contacto = Integer.parseInt(request.getParameter("contacto"));
                    int categoria = Integer.parseInt(request.getParameter("categoria"));
                    servicio.saveRoom(new NewRoom(piso,contacto,categoria));
                    out.println("<script>");
                    out.println("document.getElementById('id').value = '';");
                    out.println("document.getElementById('nombre').value = '';");
                    out.println("document.getElementById('precio').value = '';");
                    out.println("document.getElementById('url').value = '';");
                    out.println("document.getElementById('accion').value = 'enviarFormulario';");
                    out.println("</script>");
                }
            }
            else if("editarFormulario".equals(accion) && idEditar  != -1){

                if (request.getParameter("piso") != null && request.getParameter("contacto") != null && request.getParameter("categoria") != null){
                    int piso = Integer.parseInt(request.getParameter("piso"));
                    int contacto = Integer.parseInt(request.getParameter("contacto"));
                    int categoria = Integer.parseInt(request.getParameter("categoria"));
                    Optional<Room> newRoom = servicio.updateRoom(new NewRoom(piso,contacto,categoria)  ,idEditar);
                    if(newRoom.isPresent()){
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
                    <th>Piso</th>
                    <th># Contacto</th>
                    <th>Categoria</th>
                    <th>Modificar</th>
                </tr>
                <%
                    List<Room> listado = servicio.getAllRooms();
                    if (listado == null) {
                        out.println("<tr><td>------------</td><td>------------</td><td>------------</td><td>------------</td></tr>");
                    } else {
                        for (Room data : listado) {
                %>
                <tr>
                    <td><%= data.getFloorNumber() %></td>
                    <td><%= data.getContactNumber() %></td>
                    <td><%= data.getRoomCategory() %></td>
                    <td>
                        <form action="">
                            <input type="hidden" name=<%= data.getId() %> value="enviarFormulario">
                            <button type="submit">Editar</button>
                            <%
                                String accionEditar;
                                accionEditar = request.getParameter(String.valueOf(data.getId()));

                                if ("enviarFormulario".equals(accionEditar)) {

                                    Room itemEditar = servicio.getRoomById(data.getId());
                                    if (itemEditar != null) {

                                        // Asignar valores de la categoría a los campos del formulario
                                        int id = itemEditar.getId();
                                        int contacto = itemEditar.getContactNumber();
                                        int piso = itemEditar.getFloorNumber();
                                        int categoria = itemEditar.getCategoryId();

                                        // Cargar los datos en el formulario
                                        out.println("<script>");
                                        out.println("document.getElementById('piso').value = '" + piso + "';");
                                        out.println("document.getElementById('contacto').value = '" + contacto + "';");
                                        out.println("document.getElementById('categoria').value = '" + categoria + "';");

                                        out.println("document.getElementsByName('accion')[0].value = 'editarFormulario';");
                                        out.println("document.getElementsByName('idHabitacion')[0].value = " + id + ";");

                                        out.println("</script>");

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