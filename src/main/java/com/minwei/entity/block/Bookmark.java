package com.minwei.entity.block;

import com.minwei.entity.common.RichText;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lmw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bookmark {

    /**
     * 书签标题
     */
    private List<RichText> caption;

    /**
     * 书签URL
     */
    private String url;
}
