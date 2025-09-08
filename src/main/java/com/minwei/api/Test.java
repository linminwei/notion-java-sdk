package com.minwei.api;


import com.minwei.api.request.page.RetrievePageRequest;
import com.minwei.api.response.page.RetrievePageResponse;

/**
 * @author lmw 2025/09/08
 */
public class Test {
    public static void main(String[] args) {

        NotionClient notionClient = new NotionClient("ntn_g20150367084NXY2HHtbwvM3wTvitAEvbVoJsaQp0DjeLM");
        RetrievePageRequest request = new RetrievePageRequest("1de0781b05248082a681c46ef062e8e4");
        RetrievePageResponse response = notionClient.execute(request);
        System.out.println(response);
    }
}
