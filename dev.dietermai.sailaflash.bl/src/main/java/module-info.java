module dev.dietermai.sailaflash.bl {
	exports dev.dietermai.sailaflash.bl.store;
	exports dev.dietermai.sailaflash.bl.service;

	requires transitive dev.dietermai.sailaflash.api;
	
	provides dev.dietermai.sailaflash.api.service.IBlService with dev.dietermai.sailaflash.bl.service.BlService;
}