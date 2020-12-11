module dev.dietermai.sailaflash.boot {
	exports dev.dietermai.sailaflash.boot;

	requires dev.dietermai.sailaflash.api;
	
	uses dev.dietermai.sailaflash.api.service.IPersistenceService;
	uses dev.dietermai.sailaflash.api.service.IBlService;
	uses dev.dietermai.sailaflash.api.service.IUiService;
}