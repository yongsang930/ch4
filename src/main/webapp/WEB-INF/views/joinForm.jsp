<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="false" %>
<!DOCTYPE>
<html>
<head>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/joinForm.css'/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <script src="<c:url value='/js/address.js'/>"></script>
    <script src="<c:url value='/js/id_check.js'/>"></script>
</head>
<body>
<div id="menu">
    <ul>
        <li id="logo">fastcampus</li>
        <li><a href="<c:url value='/'/>">Home</a></li>
        <li><a href="<c:url value='/board/list'/>">Board</a></li>
        <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        <li><a href="<c:url value='/login/add'/>">Sign in</a></li>
        <li><a href=""><i class="fa fa-search"></i></a></li>
    </ul>
</div>
<div id="container">
    <div id="list">
        <h3>회원가입</h3>
        <form method="post" action="/login/join">
            <table border=1>
                <tr>
                    <td colspan="2"><input type="text" name="id" id="box" class="id"
                                           autocomplete='off' placeholder="아이디 입력" required>
                        <button type="button" id="idCheck">중복체크</button>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="password" name="pwd" id="boxy"
                                           autocomplete='off' placeholder="비밀번호 입력" required></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="text" name="name" id="boxy"
                                           autocomplete='off' placeholder="이름 입력" required></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="tel" name="tel" id="boxy"
                                           autocomplete='off' placeholder="'-'없이 휴대폰 번호만 입력" required
                                           maxlength="11"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="text" name="email" id="boxy"
                                           autocomplete='off' placeholder="이메일 입력" required></td>
                </tr>
                <tr>
                    <th rowspan="3">address<br>
                        <button type="button" id="searchAddr"
                                onclick="sample4_execDaumPostcode()">search
                        </button>
                    </th>
                    <td id="boxy"><input type="text" name="post_a"
                                         id="sample4_postcode" placeholder="우편번호" required></td>
                </tr>
                <td id="boxy"><input type="text" name="road_a"
                                     id="sample4_roadAddress" autocomplete='off' placeholder="도로명주소"
                                     required></td>
                <tr>
                    <td id="boxy"><input type="text" name="detail_a"
                                         id="sample4_detailAddress" placeholder="상세주소 입력"></td>
                </tr>
                <tr>
                    <th>type</th>
                    <td>
                        <div id="radioCheck">
                            <input type="radio" name="type" value="1">판매자 <input
                                type="radio" name="type" value="2">구매자 <input
                                type="radio" name="type" value="3">관리자
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" id="ee">
                        <button id="but" type="reset">초기화</button>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" id="ee">
                        <button id="but" type="submit" id="join">가입</button>
                    </td>
                </tr>
            </table>
        </form>
        <span id="idResult" style="color: red; font-size: 15px"></span>
    </div>
</div>
</body>
</html>


