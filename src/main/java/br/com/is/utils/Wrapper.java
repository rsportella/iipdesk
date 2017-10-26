package br.com.is.utils;

import java.util.*;
import javax.xml.bind.annotation.XmlAnyElement;

/**
 * @author Portella, Rodolfo <rodolfosportella@gmail.com>
 */
public class Wrapper<T> {

    private List<T> conjunto;

    public Wrapper() {
        conjunto = new ArrayList<T>();
    }

    public Wrapper(List<T> items) {
        this.conjunto = items;
    }

    @XmlAnyElement(lax = true)
    public List<T> getItems() {
        return conjunto;
    }

}
