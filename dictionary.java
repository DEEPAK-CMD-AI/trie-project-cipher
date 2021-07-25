package trie;

public class dictionary {
private HashMap<Character,Node> roots = new HashMap<Character,Node>();
	
	public boolean search(String string) {
		if (roots.containsKey(string.charAt(0))) {
			if (string.length()==1) {
				return true;
			}
			return searchFor(string.substring(1),roots.get(string.charAt(0)));
		} else {
			return false;
		}	
	}
	
	public void insert(String string) {
		if (!roots.containsKey(string.charAt(0))) {
			roots.put(string.charAt(0), new Node());
		}
		
		insertWord(string.substring(1),roots.get(string.charAt(0)));
	}
	
	private void insertWord(String string, Node node) {
		final Node nextChild;
		if (node.children.containsKey(string.charAt(0))) {
			nextChild = node.children.get(string.charAt(0));
		} else {
			nextChild = new Node();
			node.children.put(string.charAt(0), nextChild);
		}
				
		if (string.length() == 1) {
			nextChild.endOfWord = true;
			return;
		} else {
			insertWord(string.substring(1),nextChild);
		}
	}
	

	private boolean searchFor(String string, Node node) {
		if (string.length()==0) {
			if (node.endOfWord) {
				return true;
			} else {
				return false;
			}
		}
		
		if (node.children.containsKey(string.charAt(0))) {
			return searchFor(string.substring(1),node.children.get(string.charAt(0)));
		} else {
			return false;
		}
	}
}


