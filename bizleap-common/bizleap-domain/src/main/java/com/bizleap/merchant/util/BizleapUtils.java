package com.bizleap.merchant.util;

import org.apache.commons.lang3.StringUtils;

public class BizleapUtils {

	public static String makePath(String path,String fileName) {
		if(StringUtils.isEmpty(fileName)) {
			return path;
		}
		if(StringUtils.isEmpty(path)) {
			return fileName;
		}
		if(path.endsWith("/")) {
			return path + fileName;
		}
		return path + "/" +fileName;
	}
}
