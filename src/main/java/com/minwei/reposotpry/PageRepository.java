package com.minwei.reposotpry;

import java.util.List;

/**
 * @author lmw
 */
public interface PageRepository {


    List<String> getRelationIds(String pageId, String propertyId, String token);
}
