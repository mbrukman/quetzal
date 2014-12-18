package com.ibm.research.rdf.store.hashing;

public class SimpleHashFamily implements IHashingFamily {

	private int size;
	private String[] hashFamily;

	public SimpleHashFamily(int size, String hashFamily[]) {
		this.size = size;
		this.hashFamily = hashFamily;
	}
	
	public void computeHash(String s) {
		
	}

	public int getFamilySize(String predicate) {
		return hashFamily.length;
	}

	public int hash(String s, int HashId) {
		try {
			return HashingHelper.getHashingFunction(hashFamily[HashId], size).hash(s);
		} catch (HashingException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int[] getHash(String pre) {
		int[] hashVals = new int[getFamilySize(pre)];
		for (int i = 0;i < hashVals.length;i++) {
			hashVals[i] = hash(pre, i);
		}
		return hashVals;
	}
}
