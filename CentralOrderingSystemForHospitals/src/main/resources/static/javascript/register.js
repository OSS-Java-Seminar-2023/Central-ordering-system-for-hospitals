$(document).ready(function () {
    function checkPasswordMatch() {
        var password = $("#password").val();
        var repeatPassword = $("#repeatPassword").val();

        if (password !== repeatPassword) {
            $("#password-error").html("Passwords do not match");
            return false;
        } else {
            $("#password-error").html("");
            return true;
        }
    }

    $("#password, #repeatPassword").on("keyup", function () {
        checkPasswordMatch();
    });

    $("form").submit(function (event) {
        if (!checkPasswordMatch()) {
            event.preventDefault();
        }
    });
});
