package dev.dietermai.sailaflash.ui.jfx.screen;

public interface IScreenProvider<T extends IScreenGroup<T>> {
	public IScreen getInitialScreen();
	public IScreen get(T screenType);
}
