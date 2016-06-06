package com.tipwheal.dog;

import java.io.File;
import java.lang.reflect.Method;
import java.util.TreeSet;

/**
 * Config.<br>
 * All settings. But have no use now.
 * 
 * @author Administrator
 *
 */
public class Config {
	private TreeSet<TreeSet<String>> files = new TreeSet<>();
	private File file = new File("config.ser");

	public Config() {
		if (!file.exists()) {
			TreeSet<String> action = new TreeSet<>();
			action.add("show");
			action.add("feed");
			action.add("play");
			action.add("delete");
			action.add("add");
			action.add("name");
			action.add("random");
			files.add(action);
			save();
			load();
		} else {
			load();
		}
	}

	/**
	 * save.
	 */
	public void save() {
		IOHelper.saveObject("config.ser", files);
	}

	/**
	 * load.
	 */
	@SuppressWarnings("unchecked")
	public void load() {
		files = (TreeSet<TreeSet<String>>) IOHelper.readObject("config.ser");
	}

	public void add() {
		Method m;
		try {
			m = new Action().getClass().getDeclaredMethod("show", Dog.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
}
