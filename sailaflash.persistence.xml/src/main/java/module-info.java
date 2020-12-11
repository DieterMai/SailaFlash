module dev.dietermai.sailaflash.persistence.xml {
	exports dev.dietermai.sailaflash.persistence.xml.spi;
	exports dev.dietermai.sailaflash.persistence.xml.node;

	requires transitive dev.dietermai.sailaflash.api;
	requires dev.dietermai.sailautil;
	requires java.xml;
	requires jakarta.xml.bind;
	
	provides dev.dietermai.sailaflash.api.service.IPersistenceService with dev.dietermai.sailaflash.persistence.xml.spi.XmlPersistenceSpi;
	
	opens dev.dietermai.sailaflash.persistence.xml.node;
}