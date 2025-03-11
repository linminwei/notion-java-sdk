package com.minwei.controller;

import com.minwei.api.block.BlockApiService;
import com.minwei.enums.NotionColor;
import com.minwei.http.request.block.AppendBlockChildrenRequest;
import com.minwei.http.response.NotionResponse;
import com.minwei.model.blocks.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        String blockId = "1450781b0524806492abf54d8c4b39ed";


//        FileBlock fileBlock = new FileBlock("标题","文件名","https://q0.itc.cn/q_70/images03/20240509/9ecd283c00d24123b0388b27d62bfb7c.jpeg");

        HeadingOneBlock headingOneBlock = new HeadingOneBlock("1", NotionColor.RED, true);
        HeadingTwoBlock headingTwoBlock = new HeadingTwoBlock("2", NotionColor.RED, true);
        HeadingThreeBlock headingThreeBlock = new HeadingThreeBlock("3", NotionColor.RED, true);
//
        List<NotionBlock> blocks = new ArrayList<>();
        blocks.add(headingOneBlock);
        blocks.add(headingTwoBlock);
        blocks.add(headingThreeBlock);

//        ImageBlock imageBlock = new ImageBlock("https://q0.itc.cn/q_70/images03/20240509/9ecd283c00d24123b0388b27d62bfb7c.jpeg");

//        HeadingTwoBlock headingTwoBlock = new HeadingTwoBlock("122222", NotionColor.BROWN_BACKGROUND, true);


        ParagraphBlock paragraphBlock = new ParagraphBlock("1111111111111111111111111111", NotionColor.GREEN, blocks);


        TableOfContentsBlock tableOfContentsBlock = new TableOfContentsBlock(NotionColor.RED);


        AppendBlockChildrenRequest re = new AppendBlockChildrenRequest(Collections.singletonList(tableOfContentsBlock), null);


        NotionResponse<NotionBlock> response = blockApiService.appendBlockChildren(token, blockId, re);


//        NotionClient notionClient = new NotionClient(token);
//
//        NotionResponse<NotionResponse> notionResponseNotionResponse = notionClient.get("/pages/1450781b0524806492abf54d8c4b39ed", NotionResponse.class);

        System.out.println(response);
    }


}
