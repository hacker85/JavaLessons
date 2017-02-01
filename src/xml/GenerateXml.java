package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class GenerateXml {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("root");
        Element font = document.createElement("font");
        Text text = document.createTextNode("TimesNewRoman");
        document.appendChild(root);
        root.appendChild(font);
        font.appendChild(text);
        font.setAttribute("size", "20");

//        Transformer t = TransformerFactory.newInstance().newTransformer();
//        t.setOutputProperty(OutputKeys.INDENT, "yes");
//        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("temp.xml")));

//        DOMImplementation impl = document.getImplementation();
//        DOMImplementationLS implLS = (DOMImplementationLS)impl.getFeature("LS", "3.0");
//        LSSerializer ser = implLS.createLSSerializer();
//        ser.getDomConfig().setParameter("format-pretty-print", true);
//        String str = ser.writeToString(document);

//        LSOutput out = implLS.createLSOutput();
//        out.setEncoding("UTF-8");
//        out.setByteStream(Files.newOutputStream(Paths.get("temp.xml")));
//        ser.write(document, out);
    }
}
