package com.sxk.common.fomat.util;

import com.sun.istack.internal.Nullable;

public class StringUtils {


	public static boolean hasLength(@Nullable String str) {
		return (str != null && !str.isEmpty());
	}

	public static boolean hasText(@Nullable String str) {
		return (str != null && !str.isEmpty() && containsText(str));
	}

	private static boolean containsText(CharSequence str) {
		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}
		return false;
	}

}
