package org.aktin;

import java.util.Set;

import org.aktin.dwh.PreferenceKey;

public interface Preferences {

	String get(String key);

	default String get(PreferenceKey key){
		return get(key.key());
	}
	Set<String> keySet();
}
