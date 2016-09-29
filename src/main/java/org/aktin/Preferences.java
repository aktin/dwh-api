package org.aktin;

import java.util.Set;

public interface Preferences {

	String get(String key);

	Set<String> keySet();
}
