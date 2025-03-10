package com.minwei.entity.block;

/**
 * @author lmw
 */
public abstract class AbstractBlock implements Block {
    private String type;

    private String object = "block";

    protected AbstractBlock() {
    }

    protected AbstractBlock(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }


    @Override
    public String getObject() {
        return object;
    }
}
