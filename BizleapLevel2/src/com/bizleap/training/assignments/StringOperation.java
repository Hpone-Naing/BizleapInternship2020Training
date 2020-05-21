package com.bizleap.training.assignments;

public class StringOperation {

	private String sequence;

	public StringOperation() {
	}

	public StringOperation(String string) {
		this.sequence = string;
	}

	public String getString() {
		return sequence;
	}

	public void setString(String string) {
		this.sequence = string;
	}

	public boolean equals(Object object) {
		if (this.sequence.equals((String) object))
			return true;
		return false;
	}

	public int length() {
		return sequence.length();
	}

	public boolean contains(CharSequence s) {
		return sequence.contains(s);
	}

	public String replace(char oldChar, char newChar) {
		return sequence.replace(oldChar, newChar);
	}

	public boolean startsWith(String prefix) {
		return sequence.startsWith(prefix);
	}

	public boolean endsWith(String suffix) {
		return sequence.endsWith(suffix);
	}

	public String concat(String str) {
		return sequence.concat(str);
	}

	public String[] split(String regex) {
		return sequence.split(regex);
	}

	public String trim() {
		return sequence.trim();
	}

	public String toLowerCase() {
		return sequence.toLowerCase();
	}

	public String toUpperCase() {
		return sequence.toUpperCase();
	}
}