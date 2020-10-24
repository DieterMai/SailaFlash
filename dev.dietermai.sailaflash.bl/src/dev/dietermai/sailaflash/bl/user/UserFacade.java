package dev.dietermai.sailaflash.bl.user;

import java.util.List;
import java.util.function.Consumer;

import dev.dietermai.sailaflash.api.bl.IUserFacade;
import dev.dietermai.sailaflash.api.model.IUser;

public class UserFacade implements IUserFacade {
	
	private final UserStore store;
	
	public UserFacade(final UserStore userStore) {
		this.store = userStore;
	}
	

	@Override
	public void addUserListListener(Consumer<IUserFacade> listener) {
		store.addUserListListener(listener);
		
	}

	@Override
	public List<? extends IUser> getUserList() {
		return store.getUserList();
	}
	
}
