module dev.dietermai.sailaflash.persistence.xml {
	exports dev.dietermai.sailaflash.persistence.xml;
	exports dev.dietermai.sailaflash.persistence.xml.node;

	requires dev.dietermai.sailaflash.api;
	requires java.xml;
	requires jakarta.xml.bind;
	
	provides dev.dietermai.sailaflash.api.service.IPersistenceService with dev.dietermai.sailaflash.persistence.xml.XmlPersistenceSpi;
	
	opens dev.dietermai.sailaflash.persistence.xml.node;
}