package graphics;

import com.sun.scenario.Settings;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
                tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
                tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(filename)));

            } catch (FileNotFoundException | TransformerException e1) {
                e1.printStackTrace();
            }

        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        }
    }

}
