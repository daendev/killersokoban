package graphics;

import com.sun.scenario.Settings;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SettingsData {

    private int width;
    private int height;
    private int playerCount;

    public SettingsData(int w, int h, int p){
        width = w;
        height = h;
        playerCount = p;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getPlayerCount(){
        return playerCount;
    }

    public void write(String filename){
        Document dom;
        Element e;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();

            Element root = dom.createElement("settings");

            e = dom.createElement("width");
            e.appendChild(dom.createTextNode(Integer.toString(width)));
            root.appendChild(e);

            e = dom.createElement("height");
            e.appendChild(dom.createTextNode(Integer.toString(height)));
            root.appendChild(e);

            e = dom.createElement("players");
            e.appendChild(dom.createTextNode(Integer.toString(playerCount)));
            root.appendChild(e);

            dom.appendChild(root);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();
                tr.setOutputProperty(OutputKeys.INDENT, "yes");
                tr.setOutputProperty(OutputKeys.METHOD, "xml");
                tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(filename)));

            } catch (FileNotFoundException | TransformerException e1) {
                e1.printStackTrace();
            }

        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        }
    }

    public void read(String filename){
        Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(filename);
            Element doc = dom.getDocumentElement();
            String w = getTextValue("10", doc, "width");
            String h = getTextValue("10", doc, "height");
            String p = getTextValue("2", doc, "players");
            width = Integer.parseInt(w);
            height = Integer.parseInt(h);
            playerCount = Integer.parseInt(p);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

}
