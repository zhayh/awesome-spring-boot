package edu.niit.ioc.demo5;

import java.util.*;

/**
 * @author : zhayh
 * @date : 2020-2-10 14:03
 * @description : 复杂类型的Bean
 */
public class CollectionBean {
    // 数组类型
    private String[] arrs;
    // List集合类型
    private List<String> list;
    // Set集合类型
    private Set<String> set;
    // map集合类型
    private Map<String, String> map;
    // 属性类型
    private Properties properties;

    public String[] getArrs() {
        return arrs;
    }

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "CollectionBean{" +
                "arrs=" + Arrays.toString(arrs) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
