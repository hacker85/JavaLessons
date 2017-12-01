<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/login" method="post">
    <c:if test="${param.error != null}">
        <p>Invalid username and password.</p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p>You have been logged out.</p>
    </c:if>
    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
    </p>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn">Log in</button>
    <input id="remember_me" name="remember-me" type="checkbox"/>
    <label for="remember_me" class="inline">Remember me</label>
</form>