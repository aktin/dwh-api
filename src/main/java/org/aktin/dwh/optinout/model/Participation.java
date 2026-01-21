package org.aktin.dwh.optinout.model;

import java.util.Arrays;

public enum Participation {
	/** Patient specifically wants to participate */
	OptIn("I"),
	/** Patient wants to be excluded */
	OptOut("O");

	/**
	 * helper functions for (de-)serialization
	 */
	private String code;

	Participation(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static Participation fromCode(String code) {
		return Arrays.stream(values()).filter(a -> a.code.equals(code)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Unknown database value: " + code));
	}
}
