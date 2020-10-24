package dev.dietermai.sailaflash.api.bl;

import java.util.List;
import java.util.function.Consumer;

import dev.dietermai.sailaflash.api.model.IUser;

public interface IUserFacade {
	public void addUserListListener(Consumer<IUserFacade> listener);
	public List<? extends IUser> getUserList();
}
