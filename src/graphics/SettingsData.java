package graphics;

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

/**
 * A beállitások kezelőosztálya.
 */
public class SettingsData {

    /**
     * Pálya szélesség
     */
    private int width;

    /**
     * Pálya magasság
     */
    private int height;

    /**
     * Játékosok száma
     */
    private int playerCount;

    /**
     * @param w szélesség
     * @param h magasság
     * @param p játékosszám
     * Inicializálja az osztályt a megadott értékekkel.
     */
    public SettingsData(int w, int h, int p){
        width = w;
        height = h;
        playerCount = p;
    }

    /**
     * @return szélesség
     */
    public int getWidth(){
        return width;
    }

    /**
     * @return magasság
     */
    public int getHeight(){
        return height;
    }

    /**
     * @return játékosszám
     */
    public int getPlayerCount(){
        return playerCount;
    }

    /**
     * @param filename a fájl neve ahova kiirjuk a beállitásokat
     * Kiirja az osztály tartalmát a megadott fájlba.
     */
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

    /**
     * @param filename a fájl ahonnan beolvassuk a beállitásokat.
     * Beolvassa a beállitásokat a megadott fájlból.
     */
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

    /**
     * @param def Alapérték.
     * @param doc A dokumentum ahonnan betöltjük
     * @param tag A beállitás tag-je.
     * @return A beolvasott érték.
     * Beolvassa a megadott értéket a megadott helyról és visszatér vele.
     */
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
