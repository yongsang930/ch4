$(document).ready(function() {
    $("#idCheck").click(function() {

        var bool = $(".id").val();

        if (bool == null || bool == "") {
            return alert("아이디를 입력하세요");
        }

        $.post("/login/idCheck", {
            id : $(".id").val()
        }).done(function(data) {
            $("#idResult").text(data);
        });
    });

    $("#join").click(function() {
        if ($("#idResult").text().trim() != "사용이 가능합니다.") {
            return alert("아이디 중복체크 먼저 진행해주세요.");
        }
    });
});