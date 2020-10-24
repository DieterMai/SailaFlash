package dev.dietermai.sailaflash.bl.user;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import dev.dietermai.sailaflash.api.bl.IUserFacade;
import dev.dietermai.sailaflash.api.model.IUser;


public class UserStore {

	private Long lastId = Long.valueOf(0L);
	
	private final List<Consumer<IUserFacade>> listeners = new ArrayList<>();
	
	private List<User> userList = new ArrayList<>();
	
	// List for testing
	{
		userList.add(createUser(getNextId(), "Sabine", null));
		userList.add(createUser(getNextId(), "Max", null));
		userList.add(createUser(getNextId(), "Beate", null));
		userList.add(createUser(getNextId(), "Beate", null));
		userList.add(createUser(getNextId(), "Mr. Vogel", null));
		userList.add(createUser(getNextId(), "FooBar", null));
	}
	
	private Long getNextId() {
		return lastId += 1L;
	}
	
	public void addUserListListener(Consumer<IUserFacade> listener) {
		listeners.remove(listener);
		listeners.add(listener);
	}

	public List<IUser> getUserList() {
		System.err.println(Thread.currentThread().getStackTrace()[1] + " not implemented!");
		return userList.stream().map(user -> user.getViewAdapter()).collect(Collectors.toList());
	}
	
	
	// DEBUG
	private User createUser(Long id, String name, String password) {
		User user = new User(id);
		user.setName(name);
		user.setPassword(password);
		return user;
	}
}
