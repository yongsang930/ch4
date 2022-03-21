$(document).ready(function () {
    $("#idCheck").click(function () {
        let bool = $(".id").val();
        let cnt;

        if (bool == null || bool == "") {
            return alert("아이디를 입력하세요");
        }

        $.ajax({
            headers: {"content-type": "application/json"},
            type: 'post', //POST 방식으로 전달
            url: '/ch4/login/idCheck', //Controller에서 인식할 주소
            data: bool,
            success: function (result) {
                cnt = result;
                console.log("1")
                if (result == 0)
                    $("#idResult").html("사용이 가능합니다.");
                console.log("2")
                if (result == 1)
                    $("#idResult").html("이미 사용중인 아이디입니다.");
            },
            error: function () {
                alert("에러입니다");
            }
        });
        console.log("3")

        $("#join").click(function () {
            // if ($("#idResult").text().trim() != "사용이 가능합니다.") {
            if (cnt == 1) {
                return alert("아이디 중복체크 먼저 진행해주세요.");
            }
        });
    });
});