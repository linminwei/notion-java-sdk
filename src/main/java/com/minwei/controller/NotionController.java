package com.minwei.controller;

import com.minwei.api.block.BlockApiService;
import com.minwei.config.NotionConfig;
import com.minwei.http.request.block.AppendBlockChildrenRequest;
import com.minwei.http.response.NotionResponse;
import com.minwei.model.blocks.NotionBlock;
import com.minwei.model.blocks.PdfBlock;
import com.minwei.model.blocks.VideoBlock;
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
        String databaseId = notionConfig.databaseId("xxxx");

//
//        BookmarkBlock bookmarkBlock = new BookmarkBlock("百度翻译", "www.baidu.com");
//
//        BulletedListItemBlock block = new BulletedListItemBlock("123", NotionColor.RED,Collections.singletonList(bookmarkBlock));
//        ""

        String blockId = "1b40781b052480daae88e4713b4e172f";

//        CalloutBlock calloutBlock = new CalloutBlock("33333","http://e.hiphotos.baidu.com/image/pic/item/a1ec08fa513d2697e542494057fbb2fb4316d81e.jpg",null,NotionColor.RED);
//
//        CodeBlock codeBlock = new CodeBlock("1111","222", NotionCodeLanguage.BASH);
//
//
//

        PdfBlock pdfBlock = new PdfBlock("1111", "http://www.leomay.com/upload/file/mmo-20170707165001.pdf");

        VideoBlock videoBlock = new VideoBlock("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");

        NotionResponse<NotionBlock> response = blockApiService.appendBlockChildren(token, "1450781b0524806492abf54d8c4b39ed"
                , new AppendBlockChildrenRequest(Collections.singletonList(videoBlock), null));


//        NotionResponse<NotionBlock> response = blockApiService.retrieveBlockChildren(token, blockId);

        System.out.println(response);
    }


}
