<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/LMS" user="app" password="app"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Update User Details</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <header>
            <h1>Book Management System</h1>
            <p>Perpustakaan Tun Abdul Razak (PTAR)<br>Universiti Teknologi MARA (UiTM)</p>
        </header>
        <main>
            <article>
                <sql:query var="result" dataSource="${myDatasource}">
                    SELECT * FROM LOGIN WHERE STAFFID=${param.id}
                </sql:query>    
                <h3>Update User Details</h3>    
                <c:forEach var="row" items="${result.rows}">
                    <form action="updateuser" method="POST">
                        <table>
                            <tr>
                                <td>Staff ID:</td>
                                <td><input type="text" name="tid" disabled="true" value="${row.staffid}"</td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type="password" name="pass" value="${row.password}"</td>
                            </tr>
                            <tr>
                                <td>Full Name:</td>
                                <td><input type="text" name="name" value="${row.firstname}"</td>
                            </tr>
                        </table>
                        <input type="radio" name="sid" value="${row.staffid}" hidden="true" checked="true">    
                        <input type="submit" value="Submit" style="width: 200px;"   > 
                    </form>
                </c:forEach>
            </article>
        </main>
        <footer>
            Copyright &copy; <script type="text/javascript">document.write(new Date().getFullYear());</script>, Code by Tengku Nazmi<br>
            Best Viewed Using Firefox 85, Chrome 88, Edge 88
        </footer>
    </body>
</html>