package com.tipwheal.dog;

import java.util.Random;

/**
 * Action.
 *
 * @author Administrator
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
            case "help":
                System.out.println(this.getAllCommands());
                break;
            case "show":
                if (actions.length == 1) {
                    System.out.println(dog.show());
                } else if (actions.length == 2) {
                    System.out.println(this.show(actions[1], dog));
                }
                break;
            case "feed":
                System.out.println(dog.feed());
                break;
            case "add":
                dog.getActions().add(action.substring(action.indexOf(" ") + 1));
                break;
            case "delete":
                dog.getActions().delete((action.substring(action.indexOf(" ") + 1)));
                break;
            case "name":
                dog.setName(action.substring(action.indexOf(" ") + 1));
                break;
            case "random":
                AutoPlayer.turn(actions[1]);
                break;
            case "play":
                this.play(dog, actions);
                break;
            case "wash":
                dog.wash();
                System.out.println("You wash " + dog.getName() + ", and it became more clear.");
                break;
            case "exercise":
                dog.exercise();
                System.out.println(dog.getName() + " do exercise and be stronger.");
                break;
            default:
                System.out.println("wrong command.");
                break;
        }
    }

    /**
     * show all commands can use.
     *
     * @return
     */
    public String getAllCommands() {
        StringBuilder sb = new StringBuilder("");
        sb.append("show\n");
        sb.append("feed\n");
        sb.append("add\n");
        sb.append("delete\n");
        sb.append("name\n");
        sb.append("random\n");
        sb.append("play\n");
        sb.append("wash\n");
        sb.append("exercise\n");
        sb.append("help");
        return sb.toString();
    }

    /**
     * @param mode
     * @param dog
     * @return
     */
    public String show(String mode, Dog dog) {
        StringBuilder sb = new StringBuilder("");
        switch (mode) {
            case "-a":
                sb.append("name\t" + dog.getName() + "\n");
                sb.append("hungary:\t" + dog.getHung() + "\n");
                sb.append("day:\t" + dog.getDay() + "\n");
                sb.append("hour:\t" + dog.getHour() + "\n");
                sb.append("min:\t" + dog.getMin() + "\n");
                sb.append("mood:\t" + String.format("%.2f", dog.getMood()) + "\n");
                sb.append("clean:\t" + String.format("%.2f", dog.getClean()) + "\n");
                sb.append("strength:\t" + String.format("%.2f", dog.getStrength()));
                break;
        }
        return sb.toString();
    }

    /**
     * randomly.
     *
     * @param dog
     */
    public String randomShow(Dog dog) {
        Random rnd = new Random();
        String result = "";
        switch (rnd.nextInt(dog.getActions().size() + 1)) {
            case 0:
                result += dog.getName() + " has no thing to do.";
                break;
            default:
                result += dog.getName() + " " + dog.getActions().get(rnd.nextInt(dog.getActions().size()));
                break;
        }
        return result;
    }

    public void play(Dog dog, String[] actions) {
        if (actions.length == 1) {
            dog.play();
            System.out.println(dog.getName() + " plays and be happier.");
        } else if (actions.length == 3) {
            switch (actions[1]) {
                case "-t":
                    dog.play(this.getUseAble(actions[2]));
                    break;
            }
        }
    }

    /**
     * get UseAble
     *
     * @param name
     * @return
     */
    public UseAble getUseAble(String name) {
        switch (name) {
            case "basketball":
                return new BasketBall();
        }
        return null;
    }
}
