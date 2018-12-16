package com.rokomari.beans;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Status {

	String sataus;

	public Status(String sataus) {
		super();
		this.sataus = sataus;
	}

}
