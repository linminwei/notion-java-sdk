package com.minwei.controller;

import com.minwei.api.block.BlockApiService;
import com.minwei.entity.block.Block;
import com.minwei.entity.block.BookmarkBlock;
import com.minwei.model.request.block.AppendBlockChildrenRequest;
import com.minwei.model.response.NotionResponse;
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

    @GetMapping(value = "/test")
    public void test() {

        BookmarkBlock bookmarkBlock = new BookmarkBlock(null, "1fhakf");
//
        String token = "secret_iX3U9fFKNOLcvC9D8S5D2ga8wUhHJ7FDh2g6RXsGFEl";

        String blockId = "1450781b0524806492abf54d8c4b39ed";


        AppendBlockChildrenRequest request = new AppendBlockChildrenRequest(Collections.singletonList(bookmarkBlock));

        NotionResponse<Block> response = blockApiService.appendBlockChildren(token, blockId, request);


//        NotionClient notionClient = new NotionClient(token);
//
//        NotionResponse<NotionResponse> notionResponseNotionResponse = notionClient.get("/pages/1450781b0524806492abf54d8c4b39ed", NotionResponse.class);

        System.out.println(response);
    }


}
