package com.minwei.controller;

import com.minwei.api.block.BlockApiService;
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

        String blockId = "1450781b05248058982acbb1b75bd954";

        NotionBlock notionResponse = blockApiService.retrieveBlock(token, blockId);

        System.out.println(notionResponse);
    }


}
