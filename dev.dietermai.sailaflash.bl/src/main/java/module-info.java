import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.bl.service.BlService;

module dev.dietermai.sailaflash.bl {
	requires transitive dev.dietermai.sailaflash.api;
	
	exports dev.dietermai.sailaflash.bl.service;
	
	provides IBlService with BlService;
}