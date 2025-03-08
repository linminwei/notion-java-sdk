package com.minwei.controller;

import com.minwei.dto.AddBookMarkBlockDTO;
import com.minwei.service.BlockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lmw
 */
@RestController
@RequestMapping("/notion")
public class NotionController {

    @Resource
    private BlockService blockService;

    @GetMapping(value = "/test")
    public void test() {
        AddBookMarkBlockDTO addBookMarkBlockDTO = new AddBookMarkBlockDTO();
        addBookMarkBlockDTO.setPageId("1450781b0524806492abf54d8c4b39ed");
        addBookMarkBlockDTO.setCaption("测试一下");
        addBookMarkBlockDTO.setUrl("https://open.dangdang.com/index.php?c=documentCenterG3&f=show&page_id=92");
        blockService.addBookmarkBlock(addBookMarkBlockDTO);
    }


}
