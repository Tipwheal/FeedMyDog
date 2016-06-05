package com.tipwheal.dog;

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
		switch (action) {
		case "show":
			show(dog);
			break;
		case "feed":
			feed(dog);
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
}
