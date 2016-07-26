<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="login" method="post">
    <fieldset>
        <legend>Logging in</legend>
        <dl>
            <dt>Enter login:</dt>
            <dd><input type="text" name="login" required/></dd>
        </dl>
        <dl>
            <dt>Enter password:</dt>
            <dd><input type="password" name="password" required/></dd>
        </dl>
        <button class="btn btn-primary" type="submit">Log In</button>
        <a class="btn btn-primary" href="users/register">Register</a>
    </fieldset>
</form>