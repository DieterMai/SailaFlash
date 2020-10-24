package dev.dietermai.sailaflash.bl.user;

import dev.dietermai.sailaflash.api.model.IUser;

public class UserViewAdapter implements IUser {

	private final User user;
	
	UserViewAdapter(User user) {
		this.user = user;
	}
	
	@Override
	public String getName() {
		return user.getName();
	}

	@Override
	public boolean hasPassowrd() {
		return user.hasPassowrd();
	}

	@Override
	public Long getId() {
		return user.getId();
	}
}
