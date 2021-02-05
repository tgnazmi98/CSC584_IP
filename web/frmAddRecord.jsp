<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<sql:setDataSource var="myDatasource" driver="org.apache.derby.jdbc.ClientDriver" url="jdbc:derby://localhost:1527/LMS" user="app" password="app"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <style type="text/css">
            table{
                margin-left: auto;
		margin-right: auto;
		text-align: left;
            }
	</style>
	<title>Add New Student</title>
	<link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <sql:query var="result1" dataSource="${myDatasource}">
            SELECT BOOKID,BOOKTITLE FROM BOOK
        </sql:query>
        <sql:query var="result2" dataSource="${myDatasource}">
            SELECT STUDENTID,STUDENTNAME FROM STUDENT
        </sql:query>    
	<header>
            <h1>Book Management System</h1>
            <p>Perpustakaan Tun Abdul Razak (PTAR)<br>Universiti Teknologi MARA (UiTM)</p>
	</header>
	<main>
            <article>
                <h3>Add New Record</h3>
		<form action="addrecord" method="POST">
                    <table>
                        <tr>
                            <td>Book ID:</td>
                            <td>
                                <select name="bid" style="width: 400px;">
                                <c:forEach var="row" items="${result1.rows}">
                                    <option value="${row.bookid}"><c:out value="${row.booktitle}"/></option>
                                </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Student ID:</td>
                            <td>
                                <select name="sid" style="width: 400px;">
                                    <c:forEach var="row1" items="${result2.rows}">
                                        <option value="${row1.studentid}"><c:out value="${row1.studentname}"/></option>
                                    </c:forEach>
                                </select>
                            </td>
			</tr>
			<tr>
                            <td>Start Date:</td>
                            <td><input type="date" name="sdate" style="width: 400px;"></td>
			</tr>
			<tr>
                            <td>End Date:</td>
                            <td><input type="date" name="edate" style="width: 400px;"></td>
			</tr>
                    </table>
                    <input type="submit" value="Submit">
                </form>
            </article>
	</main>
        <footer>
            Copyright &copy; <script type="text/javascript">document.write(new Date().getFullYear());</script>, Code by Tengku Nazmi. <a href="mailto:tgnazmi98@gmail.com">Contact</a><br>
            Best Viewed Using Firefox 85, Chrome 88, Edge 88, IE 20
        </footer>

    </body>
</html>