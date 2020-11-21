package dev.dietermai.sailaflash.persistence.xml;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class Saver {

	public void save(Document document) {
		try {
			// TODO maybe we don't need to create all this every time
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;

			transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(document);

			File file = new File(".\\cards.xml");
			System.out.println("PersistenceSpi.initializeCardDocument() writing file to " + file.getAbsolutePath());

			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
