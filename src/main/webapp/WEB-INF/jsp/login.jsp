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
        <a class="btn btn-primary" onclick="reg()">Register</a>
    </fieldset>
</form>
<div class="modal fade regForm">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Register</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" action="register" id="regForm" autocomplete="off">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="lgn">Login:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="newlogin" id="lgn" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="psw">Password:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="password" name="newpassword" id="psw" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary pull-right">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div hidden
</body>
<script>
    function reg() {
        $('#regForm')[0].reset();
        $('.regForm').modal();
    }
    //    $(function () {
    //        $('#regForm').submit(function () {
    //            $.post('url',
    //                    $(this).serialize(),
    //                    function (data, status) {
    //                        console.log(data + ", " + status);
    //                    });
    //            return false;
    //        })
    //    })
</script>