package com.minwei.notion.databases.query.filter;

public class CheckboxFilter extends AbstractPropertyFilter{
    private Checkbox checkbox;

    public CheckboxFilter(String property) {
        super(property);
        this.checkbox = new Checkbox();
    }

    public Checkbox getCheckbox() {
        return checkbox;
    }

    public class Checkbox {
        private Boolean equals;
        private Boolean doesNotEqual;

        public void setEquals(Boolean equals) {
            this.equals = equals;
        }

        public Boolean getEquals() {
            return equals;
        }

        public void setDoesNotEqual(Boolean doesNotEqual) {
            this.doesNotEqual = doesNotEqual;
        }

        public Boolean getDoesNotEqual() {
            return doesNotEqual;
        }
    }
}
