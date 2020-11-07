import dev.dietermai.sailaflash.persistence.xml.PersistenceSpi;

module dev.dietermai.sailaflash.persistence.xml {
	requires dev.dietermai.sailaflash.api;
	requires java.xml;
	
	provides dev.dietermai.sailaflash.api.service.IPersistenceService with PersistenceSpi;
}