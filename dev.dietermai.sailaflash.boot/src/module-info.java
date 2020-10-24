import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.api.service.IUiService;

/**
 * @author Dieter
 *
 */
module dev.dietermai.sailaflash.boot {
	requires java.base;
	requires dev.dietermai.sailaflash.api;
	
	uses IBlService;
	uses IUiService;
}