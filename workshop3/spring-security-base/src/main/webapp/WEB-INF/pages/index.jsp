<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Page for logged users</title>
        </head>
        <body>
            <div style="text-align: center;">
                <h1 style="alignment-adjust: central">Main page</h1>

                <a href="<c:url value='/user'/>" >User panel</a>
                <a href="<c:url value='/admin'/>" >Admin panel</a>
                
                <form action="<c:url value='/j_spring_security_logout' />" method="post" id="logoutForm">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form>
                <script>
                    function formSubmit() {
                        document.getElementById("logoutForm").submit();
                    }
                </script>
                
                <a href="javascript:formSubmit()"> Logout</a>

            </div>
        </body>
    </html>
</f:view>
