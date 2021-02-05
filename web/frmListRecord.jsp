<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/LMS" user="app" password="app"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Record List</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <header>
            <h1>Book Management System</h1>
            <p>Perpustakaan Tun Abdul Razak (PTAR)<br> Universiti Teknologi MARA (UiTM)</p>
        </header>
        <main>
            <article>
                <sql:query var="result" dataSource="${myDatasource}">
                    SELECT * FROM RECORD
                </sql:query>
                <h3>Record List</h3>
                <table border='1' width="100%">
                    <tr>
                        <th>RECORD ID</th>
                        <th>BOOK ID</th>
                        <th>STUDENT ID</th>
                        <th>START DATE</th>
                        <th>RETURN DATE</th>
                        <th></th>
                    </tr>
                    <c:forEach var="row" items="${result.rows}">
                        <tr>
                            <td><c:out value="${row.recordid}"/></td>
                            <td><c:out value="${row.bookid}"/></td>
                            <td><c:out value="${row.studentid}"/></td>
                            <td><c:out value="${row.startdate}"/></td>
                            <td><c:out value="${row.returndate}"/></td>
                            <td>
                                <button class="but" onclick="window.location.href='frmUpdateRecord.jsp?id=${row.recordid}'">Update</button>
                                <button class="but" onclick="myFunction(${row.recordid})">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <button class="but2" onclick="window.location.href='frmAddRecord.jsp'">Add New Record</button><br>
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
            Copyright &copy; <script type="text/javascript">document.write(new Date().getFullYear());</script>, Code by Tengku Nazmi<br>
            Best Viewed Using Firefox 85
        </footer>
        <script>
            function myFunction(id){
                var pag;
                var r = confirm("Do you want to delete this record?");
                if(r==true)
                    pag="deleterecord?id="+id;
                else
                    pag="frmListRecord.jsp";
                
                window.location.href=pag;
            }
        </script>
    </body>
</html>

    
