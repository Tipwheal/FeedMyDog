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
			show(dog);
			break;
		case "feed":
			feed(dog);
			break;
		case "add":
			DogActions.add(action.substring(action.indexOf(" ") + 1));
			break;
		case "delete":
			DogActions.delete(action.substring(action.indexOf(" ") + 1));
			break;
		}
	}

	/**
	 * show the state of your dog.
	 * 
	 * @param dog
	 */
	public void show(Dog dog) {
		int age = dog.getHour();
		int hung = dog.getHung();
		System.out.println("Your dog is " + age + " hours old.");
		if (hung < 50) {
			System.out.println("It's hungary.");
		} else if (hung > 90) {
			System.out.println("It's not hungary at all.");
		}
	}

	/**
	 * feed your dog.
	 * 
	 * @param dog
	 */
	public void feed(Dog dog) {
		dog.feed();
		System.out.println("You feed your dog.");
	}

	/**
	 * randomly.
	 * 
	 * @param dog
	 */
	public void randomShow(Dog dog) {
		Random rnd = new Random();
		switch (rnd.nextInt(DogActions.size() + 1)) {
		case 0:
			int a = dog.getHung();
			System.out.println("your dog's hungary: " + a);
			break;
		default:
			System.out.println("Your dog " + DogActions.get(rnd.nextInt(DogActions.size())));
			break;
		}
	}
}
