package com.minwei.service.impl;

import com.minwei.dto.AddBookMarkBlockDTO;
import com.minwei.service.BlockService;
import com.minwei.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import notion.api.v1.NotionClient;
import notion.api.v1.model.blocks.Blocks;
import notion.api.v1.model.blocks.BookmarkBlock;
import notion.api.v1.model.pages.PageProperty;
import notion.api.v1.request.blocks.AppendBlockChildrenRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * Notion块服务实现类
 * @author lmw
 */
@Slf4j
@Service
public class BlockServiceImpl implements BlockService {

    @Resource
    private CommonService commonService;

    @Override
    public void addBookmarkBlock(AddBookMarkBlockDTO addBookMarkBlockDTO) {

//        // 获取Notion配置
//        NotionConfigVo notionConfig = commonService.getNotionConfig(addBookMarkBlockDTO.getObject());
//        // 获取Notion客户端
//        NotionClient client = commonService.getNotionClient(notionConfig.getToken());


        // 获取Notion客户端
        NotionClient client = commonService.getNotionClient("secret_iX3U9fFKNOLcvC9D8S5D2ga8wUhHJ7FDh2g6RXsGFEl");

        // 构建标题文本
        PageProperty.RichText captionText = new PageProperty.RichText();
        captionText.setText(new PageProperty.RichText.Text(addBookMarkBlockDTO.getCaption()));
        // 构建书签块对象
        BookmarkBlock.Element bookmarkBlockElement = new BookmarkBlock.Element(addBookMarkBlockDTO.getUrl(), Collections.singletonList(captionText));
        BookmarkBlock bookmarkBlock = new BookmarkBlock(bookmarkBlockElement,null,null,null,null,null,null,null,null);
        // 构建请求
        AppendBlockChildrenRequest request = new AppendBlockChildrenRequest(addBookMarkBlockDTO.getPageId(), Collections.singletonList(bookmarkBlock));

        Blocks blocks = client.appendBlockChildren(request);

        System.out.println(blocks);
    }
}
