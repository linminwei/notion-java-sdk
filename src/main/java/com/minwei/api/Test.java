package com.minwei.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minwei.api.model.file.People;
import com.minwei.api.request.page.RetrievePageRequest;
import com.minwei.api.response.page.RetrievePageResponse;
import notion.api.v1.model.users.Person;

/**
 * @author lmw 2025/09/08
 */
public class Test {
    public static void main(String[] args) throws JsonProcessingException {

//        NotionClient notionClient = new NotionClient("ntn_g20150367084NXY2HHtbwvM3wTvitAEvbVoJsaQp0DjeLM");
//        RetrievePageRequest request = new RetrievePageRequest("1de0781b05248082a681c46ef062e8e4");
//        RetrievePageResponse response = notionClient.execute(request);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(response);
//        System.out.println(s);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String json = "{\"type\":\"file\",\"file\":{\"url\":\"https://prod-files-secure.s3.us-west-2.amazonaws.com/b3818ec0-53e0-4362-86ae-499bedf1e702/a134742b-2d47-427a-bd51-f5d05ebe2e7c/5141-2020-07-27025723-1595833043851.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=ASIAZI2LB466VLWTVSF2%2F20250909%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20250909T101127Z&X-Amz-Expires=3600&X-Amz-Security-Token=IQoJb3JpZ2luX2VjEGoaCXVzLXdlc3QtMiJHMEUCIQCnLYXA2O2h70h7trweJ10rJW7tf5tvw9T8QcTBoMJeRgIgQz7nUiwNExTK7IdXiuYqQulhwCqV8IHg%2F06Sw4rNoGsqiAQI0%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARAAGgw2Mzc0MjMxODM4MDUiDGGR%2BWR83ZxxR2Jv9ircA9GSwN0pYjJgGTGIcs0d1ByZ0EHHb5WkNPMlJZAzif1BHJzG2BL9ziY%2FxZ3seEnkiSdwhLC8z8s7iUZ29tzHyvEZIhTnr2xPvJ1SgfU1woslwBtzkWf0uVfoNZoTe3hPV0JOjFQMod037EEDf3qd9BASTUVglJqQYshvZ4OrADEZQBoSWgRHmEl0XcVo2i3F4FLSdLxC5QVmqM7lp%2Bx9EEC3bNMiJfjnQ4JMis1H98J8euqKOVQrokISXVB6z9ymPYiRWaMaz%2FHODD96NglW0X%2FDbGq7eO944ioW%2F3CXds2mwMVAse%2Bn482UKGEIlMHvHr1CMU2YhHk0gwisHJPMeny%2BZmJxtn7J7LoV07c6Ps%2F4PXDUKSea%2FVnBx1L1DU7WtEg5tiw%2BdzjBz9DXzjHRAScVsomLm9%2BBNKCDGn9xFX0o9kZ1cel54g1hRzyf5VBYkq7jdzkhQuIlke%2F2LNoo7HYiGlmGIomKu0RehHqjU6AjKCr5csh3csJENxYFmBL%2Frim0BCAaq81cey2uBcw6ma89QEWLxxUG7lxsjfgzz3tpXy0z5U1m2jfruOSfNB0PT8W4P5bUVWgEnDk9kymjoGehCb7Ml3FjRqOu%2FR1zYf5Hf3%2Bs0QEkjH6udOltMITx%2F8UGOqUBfpWPmQrmXZC9HX10WOHwdvOAuyP62RTQCYUIH%2FeA0SRULRxY3WIS1o0vQzFt2uI%2FlAeQHsfz1o7NDDsJqf1bARC%2BwT4hvsXbPiZ8aG2G%2FzZwY0n9JfqKBTHLx4k7EhVOBgN4PprgU3Oa3tKrZMxaSTzBK7yZ8Mq4jx%2BVgVSw3J8gKocdn6tReOdgTO8smdivVNzN4MVUwoA08iuaIWt86We2mQBV&X-Amz-Signature=df148f0b2d4f5f176de989d3312eb5a5e12150c3753ed3d2c970a22b1f55b1a9&X-Amz-SignedHeaders=host&x-amz-checksum-mode=ENABLED&x-id=GetObject\",\"expiryTime\":\"2025-02-12\"}}";
        People people = mapper.readValue(json, People.class);

        System.out.println(people);
    }
}
