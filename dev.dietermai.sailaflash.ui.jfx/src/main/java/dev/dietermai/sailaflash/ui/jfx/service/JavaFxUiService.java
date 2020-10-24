/**
 * 
 */
package dev.dietermai.sailaflash.ui.jfx.service;

import dev.dietermai.sailaflash.api.service.IBlService;
import dev.dietermai.sailaflash.api.service.IUiService;
import dev.dietermai.sailaflash.ui.jfx.JfxBoot;

/**
 * @author Dieter
 *
 */
public class JavaFxUiService implements IUiService {

	@Override
	public void initialize(String[] args) {
		JfxBoot.instance.initialize(args);
	}

	@Override
	public void start() {
		JfxBoot.instance.start();
	}

	@Override
	public void setBlService(IBlService blService) {
		JfxBoot.instance.setBlService(blService);
	}


}
