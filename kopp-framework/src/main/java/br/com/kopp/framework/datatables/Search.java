package br.com.kopp.framework.datatables;

import java.io.Serializable;

/**
 *
 * @author kelvin
 */
public class Search implements Serializable {

    private String value;
    private String regex;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
