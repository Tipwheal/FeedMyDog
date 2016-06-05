package com.tipwheal.dog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IOHelper help with io.
 * 
 * @author Administrator
 *
 */
public class IOHelper {
	/**
	 * get input string.
	 * 
	 * @return
	 */
	public String getInput() {
		String input = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
}
