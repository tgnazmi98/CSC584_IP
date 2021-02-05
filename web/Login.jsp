<%@page import="java.util.Iterator" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
    <head>
        <style>
            input.but{
                width: 120px;
                height: 40px;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <header>
            <h1>Book Management System</h1>
            <p>Perpustakaan Tun Abdul Razak (PTAR)<br>University Teknologi MARA (UiTM)</p>
        </header>
        <main>
            <article>
                <h3>Login</h3>
                <form action="login" method="POST">
                    <table>
                        <tr>
                            <td>Username:</td>
                            <td><input type="text" name="username" style="width: 400px"></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" style="width: 400px"></td>
                        </tr>
                    </table>
                    <br><input type="submit" value="Login" class="but"><input type="reset" value="Reset" class="but">
                </form>
                <%
                    String errorMsgs = (String) request.getAttribute("errMessage");
                    if(errorMsgs != null){
                %>
                <font color="red">
                <%= errorMsgs %>
                <% } %>
                </font>
            </article>
        </main>
        <footer>
            Copyright &copy; <script>document.write(new Date().getFullYear());</script>, Code By Tengku Nazmi<br>
            Best Viewed Using Firefox 85
                
        </footer> 
    </body>
</html>