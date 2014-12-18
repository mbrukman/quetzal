package com.ibm.research.rdf.store.sparql11.model;

/**
 * models the limit and offset clauses
 */
public class LimitOffsetClauses {
	private int limit = -1;
	private int offset = -1;
	
	public LimitOffsetClauses(int lim, int off) {
		limit = lim;
		offset = off;
	}

	public int getLimit() {
		return limit;
	}

	public int getOffset() {
		return offset;
	}
	
	public String toString() {
		return ((limit > 0) ? ("LIMIT " + limit) : "") + " " + ((offset > 0) ? ("OFFSET " + offset) : "");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + limit;
		result = prime * result + offset;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LimitOffsetClauses other = (LimitOffsetClauses) obj;
		if (limit != other.limit)
			return false;
		if (offset != other.offset)
			return false;
		return true;
	}
}
