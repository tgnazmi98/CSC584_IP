<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/LMS" user="app" password="app"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Update Book Details</title>
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
                    SELECT * FROM BOOK WHERE BOOKID=${param.id}
                </sql:query>
                <h3>Update Book Details</h3>    
                <c:forEach var="row" items="${result.rows}">
                    <form action="updatebook" method="POST">
                        <table>
                            <tr>
                                <td>Book ID</td>
                                <td><input type="text" name="idd" disabled="true" value="${row.bookid}"></td>
                            </tr>
                            <tr>
                                <td>Book Title:</td>
                                <td><input type="text" name="title" value="${row.booktitle}"></td>
                            </tr>
                            <tr>
                                <td>Book Author:</td>
                                <td><input type="text" name="author" value="${row.bookauthor}"</td>
                            </tr>
                        </table>
                        <input type="radio" name="sid" value="${row.bookid}" hidden="true" checked="true">   
                        <input type="submit" value="Submit">     
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