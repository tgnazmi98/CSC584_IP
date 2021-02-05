<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/LMS" user="app" password="app"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Record Details</title>
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
                SELECT * FROM RECORD WHERE RECORDID=${param.id}
            </sql:query>
            <sql:query var="result1" dataSource="${myDatasource}">
                SELECT BOOKID,BOOKTITLE FROM BOOK
            </sql:query>
            <sql:query var="result2" dataSource="${myDatasource}">
                SELECT STUDENTID,STUDENTNAME FROM STUDENT
            </sql:query>    
                
                <h3>Update Record Details</h3>
                <c:forEach var="row" items="${result.rows}">
                <form action="updaterecord" method="POST">
                    <table border="0">
                        <tr>
                            <td>Record ID:</td>
                            <td><input type="text" name="idd" disabled="true" value="<c:out value='${row.recordid}'/>" </td>
                        </tr>
                        <tr>
                            <td>Book ID:</td>
                            <td>
                                <select name="bid" style="width: 400px;">
                                <c:forEach var="row1" items="${result1.rows}">
                                    <option value="${row1.bookid}"><c:out value="${row1.booktitle}"/></option>
                                </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Student ID:</td>
                            <td>
                                <select name="sid" style="width: 400px;">
                                    <c:forEach var="row2" items="${result2.rows}">
                                        <option value="${row2.studentid}"><c:out value="${row2.studentname}"/></option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Start Date:</td>
                            <td><input type="date" name="sdate" value="<c:out value="${row.startdate}"/>"</td>
                        </tr>
                        <tr>
                            <td>Return Date:</td>
                            <td><input type="date" name="edate" value="<c:out value="${row.returndate}"/>"</td>
                        </tr>
                    </table>
                        <input type="radio" id="${row.recordid}" name="rid" value="${row.recordid}" checked="true" hidden="true"/>
                        <input type="submit" value="Submit">
                </form>
                </c:forEach>
            </article>
                
        </main>
        <footer>
            Copyright &copy; <script type="text/javascript">document.write(new Date().getFullYear());</script>, Code by Tengku Nazmi <a href="mailto:tgnazmi98@gmail.com"></a><br>
            Best Viewed Using Firefox 85, Chrome 88, Edge 88
        </footer>
    </body>
</html>
