package com.minwei.notion.databases.query.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
public class FilesFilter extends AbstractPropertyFilter{
    private Files files;

    public FilesFilter(String property) {
        super(property);
        this.files = new Files();
    }

    @Setter
    @Accessors(chain = true)
    @Getter
    public class Files {
        private Boolean isEmpty;
        private Boolean isNotEmpty;
    }
}
