package kr.hs.study.Model2.controller;

import kr.hs.study.Model2.dto.test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class testController {
    @GetMapping("/test1")
    public String test1(@RequestParam("id") String id,
                        @RequestParam("pass") String pass,
                        Model model) {

        model.addAttribute("uid", id);
        model.addAttribute("upass", pass);

        System.out.println(id+" "+pass);

        return "result";
    }
    // 결과적으로 return 값 실행


    @GetMapping("/test2")
    public String test2(@ModelAttribute test dto, Model model) {
        //dto를 만들고, dto의 id, pass에 set을 해줌

        model.addAttribute("uid", dto.getId());
        model.addAttribute("upass", dto.getPass());

        return "result";
    }

    @GetMapping("/test3")
    public ModelAndView test3(@RequestParam("data1") int data1,
                              @RequestParam("data2") int data2,
                              ModelAndView mv) {

        mv.addObject("d1", data1);
        mv.addObject("d2", data2);
        mv.setViewName("result2");

        return mv;
    }

    @GetMapping("/test4")
    public String test4(Model model) {

        List<String> list = new ArrayList<>();
        list.add("lee");
        list.add("kim");
        list.add("park");

        model.addAttribute("list",list);

        return "result3";
    }

    @GetMapping("/test5")
    public ModelAndView test5(ModelAndView mv) {

        List<String> list = new ArrayList<>();
        list.add("lee");
        list.add("kim");
        list.add("park");

        mv.addObject("list",list);
        mv.setViewName("result3");

        return mv;
    }

}
