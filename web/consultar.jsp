<%-- 
    Document   : consultar
    Created on : Nov 27, 2013, 12:06:26 AM
    Author     : luismiranda
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar</title>
    </head>
    <body>
        <h1>Consultar</h1>
        <table border="0" class="altrowstable" id="alternatecolor">
                <thead>
                    <tr>
                        <th width="300px" align="center">
                            ci
                        </th>
                        <th width="155px" align="center">
                            nombre
                        </th>
                    </tr>
                </thead>

                <logic:iterate name="gente" id="persona">
                    <tr>
                        <td width="155px" align="center">
                            <bean:write name="persona" property="codigo"/>
                        </td>
                        <td width="155px" align="center">
                            <bean:write name="persona" property="nombre"/>
                        </td>
                    </tr>
                </logic:iterate>
            </table>

    <html:link action="back">
        <h2>
            Volver
        </h2>
    </html:link>
    </body>
</html>
