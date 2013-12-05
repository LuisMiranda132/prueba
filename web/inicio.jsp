<%-- 
    Document   : inicio
    Created on : Nov 25, 2013, 1:35:17 AM
    Author     : luismiranda
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba que prueba the prueba</title>
    </head>
    <body>
        <h1>Almacenar</h1>

        <html:form action="formulario" >
            <table border="0">
                <tbody>
                    <tr>
                        <td> Codigo </td>
                        <td>
                            <html:text name="persona" property="codigo"/>
                        </td>
                    </tr>
                    <tr>
                        <td> Nombre </td>
                        <td>
                            <html:text name="persona" property="nombre"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <p>

                <html:submit value="agregar"/>
                <html:reset value="reset"/>
            </p>
        </html:form>
           <html:link action="back">
            <h2>
                Volver
            </h2>
        </html:link>
    </body>
</html>
