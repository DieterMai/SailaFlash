module dev.dietermai.sailaflash.persistence.xml {
	exports dev.dietermai.sailaflash.persistence.xml;
	exports dev.dietermai.sailaflash.persistence.xml.node;

	requires dev.dietermai.sailaflash.api;
	requires java.xml;
	requires java.xml.bind;
}