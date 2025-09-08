package com.minwei.test.notion;


import com.minwei.test.notion.api.request.RetrievePageRequest;
import com.minwei.test.notion.api.response.RetrievePageResponse;

/**
 * 
 *
 * @author lmw 2025/06/18
 */
public class Test {
    public static void main(String[] args) {
        NotionClient notionClient = new NotionClient("ntn_g20150367084NXY2HHtbwvM3wTvitAEvbVoJsaQp0DjeLM");
        RetrievePageRequest retrievePageRequest = new RetrievePageRequest();
        retrievePageRequest.setPageId("2160781b052480a39003ebfb5cb39438");

        RetrievePageResponse response = notionClient.execute(retrievePageRequest);
        System.out.println(response);

        System.out.println(notionClient);
    }
}
