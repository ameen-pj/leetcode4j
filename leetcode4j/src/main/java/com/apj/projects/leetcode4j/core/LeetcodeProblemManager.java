package com.apj.projects.leetcode4j.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages object creation and testcase execution of problem classes
 */
public class LeetcodeProblemManager {

	private static Logger logger = LoggerFactory.getLogger(LeetcodeProblemManager.class);

	private LeetcodeProblemLoader problemLoader;

	/**
	 * Initializes LeetcodeProblemLoader and LeetcodeProblemManager
	 * 
	 * @param packageName
	 */
	public LeetcodeProblemManager(String packageName) {
		logger.info("Initializing leetcode4j...");
		this.problemLoader = new LeetcodeProblemLoader(packageName);
	}

	/**
	 * Invokes all the testcases associated with LeetcodeProblem classes
	 */
	public void runTestCases() {

		HashMap<Class<?>, ArrayList<Method>> problemTestCaseMap = this.problemLoader.getProblemTestCaseMap();

		for (Class<?> problem : problemTestCaseMap.keySet()) {
			Object obj = createProblemObject(problem);
			if (obj != null) {
				ArrayList<Method> testCases = problemTestCaseMap.get(problem);
				for (Method testCase : testCases) {
					try {
						testCase.invoke(obj);
					} catch (IllegalAccessException e) {
						logger.error("leetcode4j error", e);
					} catch (InvocationTargetException e) {
						logger.error("Testcase method error", e.getCause());
					}
				}
			}
		}
	}

	/**
	 * Creates a LeetcodeProblem class
	 * 
	 * @param problemClass
	 * @return LeetcodeProblem object
	 */
	private Object createProblemObject(Class<?> problemClass) {

		Object obj;
		try {
			obj = problemClass.getDeclaredConstructor().newInstance();
			return obj;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
			logger.error("leetcode4j error", e);
		} catch (InvocationTargetException e) {
			logger.error("Testcase method error", e.getCause());
		}
		return null;
	}

}
