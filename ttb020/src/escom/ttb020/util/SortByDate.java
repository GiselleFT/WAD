package escom.ttb020.util;

import java.util.Comparator;

import escom.ttb020.gestionescolar.mapeo.Version;

public class SortByDate implements Comparator<Version> {

	public int compare(Version a, Version b) {
		return a.getId().compareTo(b.getId());
	}
}
