package com.zhangyw.utils.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.chainsaw.Main;

public class ArrayUtil{
	public static int[] intArray(int size){
		return new int[size];
	}
	public static String[] stringArray(int size){
		return new String[size];
	}
	public static long[] longArray(int size){
		return new long[size];
	}
	public static byte[] byteArray(int size){
		return new byte[size];
	}
	public static short[] shortArray(int size){
		return new short[size];
	}
	public static float[] floatArray(int size){
		return new float[size];
	}
	public static double[] doubleArray(int size){
		return new double[size];
	}
	public static boolean[] booleenArray(int size){
		return new boolean[size];
	}
	public static char[] charArray(int size){
		return new char[size];
	}
	public static int sum(int[] intArr){
		int sum = 0;
		for(int i = 0;i<intArr.length;i++){
			sum+=intArr[i];
		}
		return sum;
	}
}
