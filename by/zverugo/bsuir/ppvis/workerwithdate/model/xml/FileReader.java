package by.zverugo.bsuir.ppvis.workerwithdate.model.xml;

import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Alex on 25.05.2015.
 */
public class FileReader {

    private String fileName;
    private TableStorage tableStorage;

    public FileReader(TableStorage tableStorage,String fileName) {
        this.fileName = fileName;
        this.tableStorage = tableStorage;

        try {
            readFile();
        } catch (ParserConfigurationException exc){
            System.out.println(exc.toString());
        } catch (IOException exc) {
            System.out.println(exc.toString());
        } catch (SAXException exc) {
            System.out.println(exc.toString());
        }
    }

    public void readFile() throws SAXException, IOException,
            ParserConfigurationException {
        File file = new File(fileName);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser parser = saxParserFactory.newSAXParser();

        parser.parse(file, new Handler(tableStorage));

    }
}
