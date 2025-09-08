package com.minwei.test.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lmw
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryRelationVo {

    /**
     * 引用页面id
     */
    private List<String> relationIds;

    /**
     * 游标
     */
    private String nextCursor;
}
