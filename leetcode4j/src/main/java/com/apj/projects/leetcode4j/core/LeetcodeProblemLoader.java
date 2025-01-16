package com.apj.projects.leetcode4j.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apj.projects.leetcode4j.annotations.LeetcodeProblem;
import com.apj.projects.leetcode4j.annotations.TestCase;

/**
 * Loads and maps problem classes and testcase methods
 */
class LeetcodeProblemLoader {

	private static final Logger logger = LoggerFactory.getLogger(LeetcodeProblemManager.class);

	private Reflections reflections;
	private Set<Class<?>> problems;
	private HashMap<Class<?>, ArrayList<Method>> problemTestCaseMap;

	/**
	 * Initializes and loads problem classes and it's corresponding test cases
	 * 
	 * @param packageName (eg. com.problems, com.leetcodeproblems)
	 */
	public LeetcodeProblemLoader(String packageName) {

		this.reflections = new Reflections(packageName);
		this.problems = getLeetcodeProblems();
		this.problemTestCaseMap = getTestCases();
	}

	/**
	 * @return Set of scanned leetcode problem classes (i.e classes annotated
	 *         with @LeetcodeProblem)
	 */
	private Set<Class<?>> getLeetcodeProblems() {

		Set<Class<?>> classes = reflections.get(Scanners.TypesAnnotated.with(LeetcodeProblem.class).asClass());
		logger.info("Loaded {} Leetcode problem classes", classes.size());
		return classes;
	}

	/**
	 * Scans testcase methods containing no arguments
	 * 
	 * @return Hashmap containing Problem and arrayList of test case methods
	 */
	private HashMap<Class<?>, ArrayList<Method>> getTestCases() {

		HashMap<Class<?>, ArrayList<Method>> map = new HashMap<Class<?>, ArrayList<Method>>();

		for (Class<?> problem : this.problems) {

			Method[] methods = problem.getDeclaredMethods();
			ArrayList<Method> testCases = new ArrayList<Method>();

			for (Method method : methods) {
				Annotation ann = method.getDeclaredAnnotation(TestCase.class);
				if (ann != null && method.getParameterCount() == 0) {
					testCases.add(method);
				}
			}
			if (testCases.size() > 0) {
				logger.info("Loading {} testcases for {}", testCases.size(), problem.getName());
				map.put(problem, testCases);
			}
		}
		return map;
	}

	/**
	 * Gets all the mapped testcase methods
	 * 
	 * @return HashMap containing problem class and ArrayList of test case methods
	 */
	public HashMap<Class<?>, ArrayList<Method>> getProblemTestCaseMap() {
		return problemTestCaseMap;
	}

}
