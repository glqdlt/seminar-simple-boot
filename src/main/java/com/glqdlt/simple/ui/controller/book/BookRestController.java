package com.glqdlt.simple.ui.controller.book;

import com.glqdlt.simple.ui.services.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
public class BookRestController {

    private static final Logger log = LoggerFactory.getLogger(BookRestController.class);

    @Value("${api.url.epg}")
    private String epgApiUrl;

    @Autowired
    RestService restService;


    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getEpgSchedules(@RequestParam int draw, @RequestParam int length, @RequestParam int
            start, @RequestParam Object searchForm) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();;
        params.add("draw", draw);
        params.add("length", length);
        params.add("start", start);
        params.add("searchForm",searchForm);

        // TODO epgApi 에서 "start" , "draw", "length" 받았던 파라미터를 그대로 똑같이 되돌려주지 않는다면, api의 return 값을 신뢰하지 말고,
        // 직접 "start", "draw" 값을 반환값에 추가하여 보내야 한다.
        return new ResponseEntity<>(restService.postDataPage(epgApiUrl, params), HttpStatus.OK);
    }
}
