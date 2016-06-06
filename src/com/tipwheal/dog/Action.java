package com.tipwheal.dog;

import java.util.Random;

/**
 * Action.
 * 
 * @author Administrator
 *
 */
public class Action {

	/**
	 * analyzed input and do action.
	 * 
	 * @param action
	 * @param dog
	 */
	public void doAction(String action, Dog dog) {
		String[] actions = action.split(" ");
		switch (actions[0]) {
		case "show":
			System.out.println(dog.show());
			break;
		case "feed":
			System.out.println(dog.feed());
			break;
		case "add":
			dog.getAction().add(action.substring(action.indexOf(" ") + 1));
			break;
		case "delete":
			dog.getAction().delete((action.substring(action.indexOf(" ") + 1)));
			break;
		case "name":
			dog.setName(action.substring(action.indexOf(" ") + 1));
			break;
		case "random":
			AutoPlayer.turn(actions[1]);
			break;
		case "play":
			dog.play();
			System.out.println("You play with " + dog.getName() + ", and it feels happy.");
			break;
		case "wash":
			dog.wash();
			System.out.println("You wash " + dog.getName() + ", and it became more clear.");
			break;
		}
	}

	/**
	 * randomly.
	 * 
	 * @param dog
	 */
	public String randomShow(Dog dog) {
		Random rnd = new Random();
		String result = "";
		switch (rnd.nextInt(dog.getAction().size() + 1)) {
		case 0:
			int a = dog.getHung();
			result += dog.getName() + "'s hungary: " + a;
			break;
		default:
			result += dog.getName() + " " + dog.getAction().get(rnd.nextInt(dog.getAction().size()));
			break;
		}
		return result;
	}
}
