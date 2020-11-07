package dev.dietermai.sailaflash.persistence.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dev.dietermai.sailaflash.api.model.CardData;
import dev.dietermai.sailaflash.api.service.IPersistenceService;
import dev.dietermai.sailaflash.persistence.xml.node.NSailaFlash;

public class PersistenceSpi implements IPersistenceService{

	@Override
	public void initialize(String[] args) {
	}

	@Override
	public void start() {
		initializeCardDocument();
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");
	}

	@Override
	public void saveNewSimpleCard(CardData cardData) {
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");
		
	}
	
	private void initializeCardDocument() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		    
		    Document doc = docBuilder.newDocument();
		    
		    Element rootElement = doc.createElement(NSailaFlash.TAG);
		    doc.appendChild(rootElement);
		    
		    
		    TransformerFactory transformerFactory =  TransformerFactory.newInstance();
		    Transformer transformer = transformerFactory.newTransformer();
		    DOMSource source = new DOMSource(doc);
		    
		    File file  = new File(".\\testing.xml");
		    System.out.println("PersistenceSpi.initializeCardDocument() writing file to "+file.getAbsolutePath());
		    
		    StreamResult result =  new StreamResult(file);
		    transformer.transform(source, result);
		    	
		}catch(ParserConfigurationException | TransformerException e){
		    e.printStackTrace();
		}
	}

}
