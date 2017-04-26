<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Secret page for admins only</title>
    </head>
    <body>
        <div style="text-align: center;margin-top: 200px;">
            <h1 style="alignment-adjust: central">Secret page for admins only</h1>
        </div>

        <form action="<c:url value='/j_spring_security_logout' />" method="post" id="logoutForm">
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
            </form>
            <script>
                function formSubmit() {
                    document.getElementById("logoutForm").submit();
                }
            </script>

            <a href="javascript:formSubmit()"> Logout</a>

    </body>
</html>
