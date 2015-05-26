package by.zverugo.bsuir.ppvis.workerwithdate.model.xml;

import by.zverugo.bsuir.ppvis.workerwithdate.model.Row;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.model.util.XMLKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by Alex on 25.05.2015.
 */
public class FileWriter {

    private TableStorage tableStorage;
    private Element table;
    private String fileName;

    public FileWriter(TableStorage tableStorage, String fileName) {
        this.tableStorage = tableStorage;
        this.fileName = fileName;

        try {
            writeFile();
        } catch (ParserConfigurationException exc) {
            System.out.println(exc.toString());
        } catch (TransformerConfigurationException exc) {
            System.out.println(exc.toString());
        } catch (TransformerException exc) {
            System.out.println(exc.toString());
        }
    }

    private void writeFile() throws ParserConfigurationException,TransformerConfigurationException,
            TransformerException {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.newDocument();

        table = document.createElement(XMLKeys.TABLE);
        document.appendChild(table);

        Element humans = document.createElement(XMLKeys.HUMANS);
        table.appendChild(humans);

        for (Row row : tableStorage.getTableData()) {
            Element human = document.createElement(XMLKeys.HUMAN);
            humans.appendChild(human);

            Element surname = document.createElement(XMLKeys.SURNAME);
            surname.appendChild(document.createTextNode(row.getFullName().getSurname()));
            human.appendChild(surname);

            Element name = document.createElement(XMLKeys.NAME);
            name.appendChild(document.createTextNode(row.getFullName().getName()));
            human.appendChild(name);

            Element secondName = document.createElement(XMLKeys.SECOND_NAME);
            secondName.appendChild(document.createTextNode(row.getFullName().getSecondName()));
            human.appendChild(secondName);

            Element birthDate = document.createElement(XMLKeys.BIRTH);
            birthDate.appendChild(document.createTextNode(row.buildFullDate(row.getBirthDate())));
            human.appendChild(birthDate);

            Element receiptDate = document.createElement(XMLKeys.RECEIPT);
            receiptDate.appendChild(document.createTextNode(row.buildFullDate(row.getReceiptDate())));
            human.appendChild(receiptDate);

            Element endDate = document.createElement(XMLKeys.END);
            endDate.appendChild(document.createTextNode(row.buildFullDate(row.getEndDate())));
            human.appendChild(endDate);
        }


        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(fileName));
        transformer.transform(source, result);
    }
}
