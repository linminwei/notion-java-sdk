package com.minwei.controller;

import com.minwei.api.BlockApiService;
import com.minwei.config.NotionConfig;
import com.minwei.http.request.block.AppendBlockChildrenRequest;
import com.minwei.http.response.NotionResponse;
import com.minwei.model.blocks.BookmarkBlock;
import com.minwei.model.blocks.NotionBlock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @author lmw
 */
@RestController
@RequestMapping("/notion")
public class NotionController {

    @Resource
    private BlockApiService blockApiService;
    @Resource
    private NotionConfig notionConfig;

    @GetMapping(value = "/test")
    public void test() {

        String token = notionConfig.getToken();

        BookmarkBlock bookmarkBlock = new BookmarkBlock("Notion API","https://developers.notion.com/");

        NotionResponse<NotionBlock> response = blockApiService.appendBlockChildren(token, "1450781b0524806492abf54d8c4b39ed", new AppendBlockChildrenRequest(Collections.singletonList(bookmarkBlock), "1b50781b052480c9aa99c369a5822ac8"));

        System.out.println(response);

    }


}
