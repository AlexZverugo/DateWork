package by.zverugo.bsuir.ppvis.workerwithdate.model.xml;

import by.zverugo.bsuir.ppvis.workerwithdate.model.Human;
import by.zverugo.bsuir.ppvis.workerwithdate.model.Row;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.model.util.XMLKeys;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.awt.Point;
import java.util.GregorianCalendar;

/**
 * Created by Alex on 25.05.2015.
 */
public class Handler extends DefaultHandler {

    private TableStorage tableStorage;
    private String tagName;
    private String surname;
    private String name;
    private String secondName;

    private GregorianCalendar birth;
    private GregorianCalendar receipt;
    private GregorianCalendar end;

    public Handler(TableStorage tableStorage) {
        this.tableStorage = tableStorage;

    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        tagName = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException{

        if (qName.equals(XMLKeys.HUMAN)) {
            tableStorage.setPerson(new Row(new Human(surname, name, secondName), birth, receipt, end));
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String value = new String(ch, start, length).trim();
        if (tagName.equals(XMLKeys.SURNAME)) {
            surname = value;
        }
        if (tagName.equals(XMLKeys.NAME)) {
            name = value;
        }
        if (tagName.equals(XMLKeys.SECOND_NAME)) {
            secondName = value;
        }
        if (tagName.equals(XMLKeys.BIRTH)) {
            birth = new GregorianCalendar(Integer.valueOf(value.substring(6,10)),
                    Integer.valueOf(value.substring(3,5)),Integer.valueOf(value.substring(0,2)));
        }
        if (tagName.equals(XMLKeys.RECEIPT)) {
            receipt = new GregorianCalendar(Integer.valueOf(value.substring(6,10)),
                    Integer.valueOf(value.substring(3,5)),Integer.valueOf(value.substring(0,2)));
        }
        if (tagName.equals(XMLKeys.END)) {
            end = new GregorianCalendar(Integer.valueOf(value.substring(6,10)),
                    Integer.valueOf(value.substring(3,5)),Integer.valueOf(value.substring(0,2)));
        }
    }

}
