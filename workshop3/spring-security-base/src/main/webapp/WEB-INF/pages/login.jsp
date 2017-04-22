<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Login page</title>
    </head>
    <body>
        <div style="text-align: center;margin-top: 200px;">
            <h1 style="alignment-adjust: central">Login page</h1>
        </div>
        <div style="margin: auto; width: 300px;" >
            <form name='loginForm'
                  action="<c:url value='/j_spring_security_check' />" method='POST'>
                <table style="padding: 20px">
                    <tr>
                        <td>User:</td>
                        <td><input type='text' name='username'></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type='password' name='password' /></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit"
                                               value="Login" /></td>
                    </tr>
                </table>

                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>
        </div>
    </body>
</html>
