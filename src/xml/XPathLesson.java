package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class XPathLesson {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("prop.xml"));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        System.out.println(xpath.evaluate("/preferences/root/node/node/node/map", document));
        System.out.println(xpath.evaluate("/preferences/root/node/node/node/map[2]", document));
        System.out.println(xpath.evaluate("count(/preferences/root/node/node/node/map)", document));
        NodeList list = (NodeList) xpath.evaluate("/preferences/root/node/node/node/map", document, XPathConstants.NODESET);
        Node node = (Node) xpath.evaluate("/preferences/root/node/node/node/map[2]", document, XPathConstants.NODE);
        int count = ((Number)xpath.evaluate("count(/preferences/root/node/node/node/map)", document, XPathConstants.NUMBER)).intValue();

    }
}
