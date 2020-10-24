package dev.dietermai.sailaflash.bl.user;

import dev.dietermai.sailaflash.api.model.IUser;

public class User{

	private final UserViewAdapter adapter;
	
	private final Long id;
	private String name;
	private String password; // TODO
	
	User(final Long id){
		this.id = id;
		this.adapter = new UserViewAdapter(this);
	}
	
	IUser getViewAdapter() {
		return adapter;
	}
	
	public String getName() {
		return name;
	}

	public boolean hasPassowrd() {
		return password != null;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return null;
	}
}
