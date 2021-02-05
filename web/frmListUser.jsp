<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/LMS" user="app" password="app"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>User List</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <header>
            <h1>Book Management System</h1>
            <p>Perpustakaan Tun Abdul Razak (PTAR)<br>Universiti Teknologi MARA (UiTM)</p>
        </header>
        <main>
            <article>
                <h3>User List</h3>
                <sql:query var="result" dataSource="${myDatasource}">
                    SELECT * FROM LOGIN
                </sql:query>
                <table border='1' width="100%">
                    <tr>
                        <th>STAFF ID</th>
                        <th>PASSWORD</th>
                        <th>NAME</th>
                        <th></th>
                    </tr>
                    <c:forEach var="row" items="${result.rows}">
                        <tr>
                            <td><c:out value="${row.staffid}"/></td>
                            <td><c:out value="${row.password}"/></td>
                            <td><c:out value="${row.firstname}"/></td>
                            <td>
                                <button  class="but" onclick="window.location.href='frmUpdateUser.jsp?id=${row.staffid}'">Update</button>
                                <button class="but" onclick="myFunction(${row.staffid})">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <button class="but2" onclick="window.location.href='frmAddUser.html'">Add New User</button><br>
                <button class="but2" onclick="window.location.href='MainMenu.html'">Go Back</button><br>
            <c:if test="${not empty errMessage}">
                    <p>
                        <font color="red">Please Correct the Following Error:
                    <ul>
                        <c:forEach var="message" items="${errMessage}">
                            <li>${message}</li>
                        </c:forEach>
                    </ul>
                    </p>
                </c:if>
            </article>
            
        </main>
        <footer>
            Copyright &copy; <script type="text/javascript">document.write(new Date().getFullYear());</script>, Code by Tengku Nazmi <a href="mailto:tgnazmi98@gmail.com"></a><br>
            Best Viewed Using Firefox 85, Chrome 88, Edge 88
        </footer>
        <script>
            function myFunction(id){
                var pag;
                var r = confirm("Dou You Want to Detete This record?");
                if (r==true)
                    pag="deleteuser?id=" + id;
                else
                    pag="frmListUser.jsp";
                
                window.location.href=pag;
            }
        </script>
    </body>
</html>

    
