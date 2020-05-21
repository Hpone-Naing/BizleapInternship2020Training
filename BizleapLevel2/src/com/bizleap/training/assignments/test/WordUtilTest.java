package com.bizleap.training.assignments.test;

import java.util.List;

import com.bizleap.training.assignments.IntegerUtil;
import com.bizleap.training.assignments.WordUtil;

public class WordUtilTest {

	public static void main(String[] args) {
		
		WordUtil wordUtil = WordUtil.getInstance();
		List<Integer> makedIntegerList = IntegerUtil.getMakedIntegerList(25);
		System.out.println("number from 1 to 20: " + makedIntegerList);		
		System.out.println( "Maked Word List: " + wordUtil.getMakedWordList(makedIntegerList));
				
		System.out.println("Multiple Time Occurance: " + wordUtil.getMultipleOccurance());
		
		System.out.println("Even Time Occurance: " + wordUtil.getEvenOccurance());
		
		System.out.println("Odd Time Occurance: " + wordUtil.getOddOccurance());
		
		
		System.out.println("Using Set Datastructor....................");
		
		System.out.println("Once Time Occurance: " + wordUtil.getOnceOccuranceTest());
		
		System.out.println("Multiple Time Occurance: " + wordUtil.getMultipleOccuranceTest2());
		
		System.out.println("Even Time Occurance: " + wordUtil.getEvenOccuranceTest());
				
		System.out.println("Odd Time Occurance: " + wordUtil.getOddOccuranceTest());

	}
}