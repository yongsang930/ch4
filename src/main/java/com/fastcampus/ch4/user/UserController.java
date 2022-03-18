package com.fastcampus.ch4.user;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserController {
    @Autowired
    UserDao userDao;

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //1. 세션을 종료
        session.invalidate();
        //2. 홈으로 이동
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, String toURL, boolean rememberId,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {


        if (!loginCheck(id, pwd)) {//1. id와 pwd를 확인
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");// 2-1 일치하지 않으면, loginForm으로 이동
            return "redirect:/login/login?msg=" + msg;
        }

        HttpSession session = request.getSession(); //2-2. id와 pwd가 일치하면,세션 객체를 얻어오기
        session.setAttribute("id", id); //  세션 객체에 id를 저장

        if (rememberId) {
            Cookie cookie = new Cookie("id", id); //1. 쿠키를 생성
            response.addCookie(cookie);//2. 응답에 저장
        } else {
            Cookie cookie = new Cookie("id", id); //1. 쿠키를 삭제
            cookie.setMaxAge(0); // 쿠키를 삭제
            response.addCookie(cookie); //2. 응답에 저장
        }
        toURL = toURL == null || toURL.equals("") ? "/" : toURL;//3. 홈으로 이동

        return "redirect:" + toURL;
    }

    private boolean loginCheck(String id, String pwd) {
        UserDto user = null;

        try {
            user = userDao.selectUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return user != null && user.getPwd().equals(pwd);
    }

    @GetMapping("/add")
    public String addForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public String add(UserDto user, HttpServletRequest request) {

        return "/";
    }
}