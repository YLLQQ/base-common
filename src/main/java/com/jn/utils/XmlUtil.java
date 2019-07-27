package com.jn.utils;

import com.google.common.base.Charsets;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * com.jn.competence.pay.util.XmlUtil
 *
 * @author eleven
 * @date 2019/04/12
 */
public class XmlUtil {

    /**
     * 通过xml转换t，自定义根结点
     *
     * @param root
     * @param xml
     * @param cl
     * @param <T>
     * @return
     */
    public static <T> T xmlToT(
            String root,
            String xml,
            Class cl
    ) {
        XStream xstream = new XStream(new DomDriver(Charsets.UTF_8.name()));

        XStream.setupDefaultSecurity(xstream);

        xstream.ignoreUnknownElements();
        xstream.allowTypes(new Class[]{cl});
        xstream.autodetectAnnotations(true);
        xstream.alias(root, cl);

        return (T) xstream.fromXML(xml);
    }

    /**
     * 通过xml转换t，根结点document
     *
     * @param xml
     * @param cl
     * @param <T>
     * @return
     */
    public static <T> T xmlToT(
            String xml,
            Class cl
    ) {
        return xmlToT("document", xml, cl);
    }

    /**
     * 获取t的xml形式
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String tToXML(T t) {
        XStream xstream = new XStream(new StaxDriver());

        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(t.getClass());
        xstream.aliasSystemAttribute(null, "class");

        return xstream.toXML(t);
    }
}
