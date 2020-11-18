package com.criptografia.util;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.criptografia.exception.CriptografiaRuntimeException;

public class CriptografiaUtil {
	public static String getAlfabeto() throws CriptografiaRuntimeException {
		return IntStream
				.rangeClosed('A', 'Z')
				.mapToObj(x -> (char) x+"")
				.collect(Collectors.joining());
	}
}
