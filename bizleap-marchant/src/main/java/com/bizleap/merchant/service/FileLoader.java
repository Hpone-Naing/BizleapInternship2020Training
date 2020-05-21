package com.bizleap.merchant.service;

public interface FileLoader {

	void start(String filePath) throws Exception;
	void finish() throws Exception;
	String getLine() throws Exception;
	boolean hasMore() throws Exception;
	int getLineNumber();
}
