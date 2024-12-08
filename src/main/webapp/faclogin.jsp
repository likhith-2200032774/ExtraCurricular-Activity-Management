<html>
<head>
    <title>Faculty Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
  <%@include file="mainnavbar.jsp" %>
 
    <h3 style="text-align: center;"><u>Faculty Login</u></h3>
    <div class="form-container">
        <form method="post" action="checkfaclogin">
            <table>
                <tr>
                    <td><label for="eemail">Enter Email ID</label></td>
                    <td><input type="email" id="femail" name="femail" required/></td>
                </tr>
                 <tr>
                    <td><label for="epwd">Enter Password</label></td>
                    <td><input type="password" id="fpwd" name="fpwd" required/></td>
                </tr>
                <tr>
                <tr>
                    <td colspan="2" class="button-container">
                        <input type="submit" value="Login"/>
                        <input type="reset" value="Clear"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>