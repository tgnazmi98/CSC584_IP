<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/LMS" user="app" password="app"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Student List</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <header>
            <h1>Book Management System</h1>
            <p>Perpustakaan Tun Abdul Razak (PTAR)<br>Universiti Teknologi MARA (UiTM)</p>
        </header>
        <main>
            <article>
                <h3>Student List</h3>
                <sql:query var="result" dataSource="${myDatasource}">
                    SELECT * FROM STUDENT
                </sql:query>
                <table border='1' width="100%">
                    <tr>
                        <th>STUDENT ID</th>
                        <th>STUDENT NAME</th>
                        <th></th>
                    </tr>
                
                    <c:forEach var="row" items="${result.rows}">
                        <tr>
                            <td><c:out value="${row.studentid}"/></td>
                            <td><c:out value="${row.studentname}"/></td>
                            <td>
                                <button class="but" onclick="window.location.href='frmUpdateStudent.jsp?id=${row.studentid}'">Update</button>
                                <button class="but" onclick="myFunction(${row.studentid})">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <button class="but2" onclick="window.location.href='frmAddStudent.html'">Add New Student</button><br>
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
            Copyright &copy; <script type="text/javascript">document.write(new Date().getFullYear());</script>, Code by Tengku Nazmi
            Best Viewed Using Firefox 85
        </footer>
        <script>
            function myFunction(id){
                var pag;
                var r = confirm("Dou you want to delete this record?");
                if (r==true)
                    pag="deletestudent?id=" + id;
                else
                    pag="frmListStudent.jsp";
                
                window.location.href=pag;
            }
        </script>
    </body>
</html>

    
