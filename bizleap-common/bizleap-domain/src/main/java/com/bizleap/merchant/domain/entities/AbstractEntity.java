package com.bizleap.merchant.domain.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AbstractEntity {

	private String name;

	public AbstractEntity() {

	}

	public AbstractEntity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(name).toString();
	}

}
