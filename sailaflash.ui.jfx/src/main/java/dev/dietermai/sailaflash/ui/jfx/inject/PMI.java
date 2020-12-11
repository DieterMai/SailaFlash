package dev.dietermai.sailaflash.ui.jfx.inject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public enum PMI {
	pmi;
	
	
	private record Tuple(Class<?> clazz, Keys key) {}
	
	private final Map<Class<?>, Object> oneMap = new HashMap<>();
	private final Map<Tuple, Object> multiMap = new HashMap<>();
	
	
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz) {
		T t = (T) oneMap.get(clazz);
		if(t == null) {
			return create(clazz);
		}else {
			return t;
		}
	}
	
	public void set(Object o) {
		oneMap.put(o.getClass(), o);
	}
	
	public <K,V extends K> void set(Class<K> key, V value) {
		oneMap.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, Keys key) {
		return (T) multiMap.get(new Tuple(clazz, key));
	}
	
	public void set(Keys key, Object instance) {
		multiMap.put(new Tuple(instance.getClass(), key), instance);
	}
	
	
	public <T> T create(Class<T> clazz) {
		try {
			Constructor<T> consturctor = clazz.getConstructor();
			T instance = consturctor.newInstance();
			set(instance);
			return instance;
		}catch(NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.err.println("exception for class "+clazz.getSimpleName());
			e.printStackTrace();
			return null;
		}
	}
}
