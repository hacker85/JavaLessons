package xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;

public class DomLesson {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        //DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("prop.xml"));
        Element root = document.getDocumentElement();
        System.out.println(root.getTagName());

        printElements(root.getChildNodes(), 0);
//        NodeList list = root.getChildNodes();
//        for (int i = 0; i < list.getHeight(); i++) {
//            Node node = list.item(i);
//            if(node instanceof Element) {
//                System.out.println(node.getNodeName());
//            }
//        }

    }
    static void printElements(NodeList list, int tabs) {
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if(node instanceof Element) {
                String value = "";
                if(!node.getTextContent().trim().isEmpty() &&  !((Text)node.getFirstChild()).getData().trim().isEmpty() && !((Text)node.getFirstChild()).getData().trim().equals("\n")) {
                    Text text = (Text)node.getFirstChild();
                    value += " = " + text.getData().trim();
                }
                System.out.println(getTab(tabs) + node.getNodeName() + value);

                NamedNodeMap attributes = node.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++)
                {
                    Node attribute = attributes.item(j);
                    String name = attribute.getNodeName();
                    String val = attribute.getNodeValue();
                    System.out.println("Atributes - " + name + " = " + val);
                }
                if(node.hasChildNodes()) {
                    printElements(node.getChildNodes(), ++tabs);
//                    if(!node.getTextContent().isEmpty()) {
//                        Text text = (Text)node.getFirstChild();
//                        System.out.println(text.getData().trim());
//                        //System.out.println(node.getTextContent());
//                    }
                }
            }
        }
    }
    static String getTab(int tabs) {
        String str = "";
        for (int i = 0; i < tabs; i++) {
            str += "\t";
        }
        return str;
    }
}
