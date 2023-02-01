<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Crud Animales</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: tomato">

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list"
                           class="nav-link">Animales</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${animal != null}">
                        <form action="update" method="post">
                        </c:if>
                        <c:if test="${animal == null}">
                            <form action="insert" method="post">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${animal != null}">
                                        Editar Animal
                                    </c:if>
                                    <c:if test="${animal == null}">
                                        Agregar Animal
                                    </c:if>
                                </h2>
                            </caption>

                            <c:if test="${animal != null}">
                                <input type="hidden" name="id" value="<c:out value='${animal.id}' />" />
                            </c:if>

                            <fieldset class="form-group">
                                <label>Nombre</label> <input type="text"
                                                             value="<c:out value='${animal.nombre}' />" class="form-control"
                                                             name="nombre" required="required">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Nombre Cientifico</label> <input type="text"
                                                                        value="<c:out value='${animal.nombreCientifico}' />" class="form-control"
                                                                        name="nombreCientifico">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Habitad</label> <input type="text"
                                                              value="<c:out value='${animal.habitad}' />" class="form-control"
                                                              name="habitad">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Especie</label> <input type="text"
                                                              value="<c:out value='${animal.especie}' />" class="form-control"
                                                              name="especie">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Peso</label> <input type="numeric"
                                                           value="<c:out value='${animal.peso}' />" class="form-control"
                                                           name="peso">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Dieta</label> <input type="text"
                                                            value="<c:out value='${animal.dieta}' />" class="form-control"
                                                            name="dieta">
                            </fieldset>
                            <fieldset class="form-group">
                                <label>Peligro Extincion</label> 
                               
                                <select name="peligroExtincion" value="<c:out value='${animal.peligroExtincion}' />"class="form-control">
                                    <option value="1">SI</option>
                                    <option value="0" selected>No</option>
                                    
                                </select>
                            </fieldset>

                            <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                </div>
            </div>
        </div>
    </body>
</html>
