package com.minwei.controller;

import com.minwei.api.block.BlockApiService;
import com.minwei.http.response.NotionResponse;
import com.minwei.model.blocks.NotionBlock;
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
    private BlockApiService blockApiService;

    @GetMapping(value = "/test")
    public void test() {


        String token = "secret_iX3U9fFKNOLcvC9D8S5D2ga8wUhHJ7FDh2g6RXsGFEl";
//        String token = "1233333";

        String blockId = "1b40781b052480c5b5aac4b94d4560f2";

        NotionResponse<NotionBlock> notionResponse = blockApiService.retrieveBlock(token, blockId);

        System.out.println(notionResponse);
    }


}
