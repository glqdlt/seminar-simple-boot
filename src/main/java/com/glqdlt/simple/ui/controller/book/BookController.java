package com.glqdlt.simple.ui.controller.book;

import com.glqdlt.simple.ui.services.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/book")
@Controller
public class BookController {

    @Value("${gateway.url}")
    private String apiGateUrl;

    @Autowired
    RestService restService;

    private final String BOOK_URL = "/api/book/list";

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(Model model) {
        model.addAttribute("bookUrl", apiGateUrl+BOOK_URL);
        return "/book/list";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detailView(@PathVariable Integer id, Model model) {

        //TODO restService를 이용하여 실제 API에 쿼리 질의 후, 데이터 반환 -> model 구현.

        model.addAttribute("id", id);
        model.addAttribute("target","ALL");
        model.addAttribute("req_time","Tue, Jan 9, 2018 08:30");
        model.addAttribute("trans_time","Tue, Jan 9, 2018 08:30");
        model.addAttribute("status","Success");
        model.addAttribute("download","/api/book/download/"+id);

        return "/book/detail";
    }

}
