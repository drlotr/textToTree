/*

 * This class defines a binary tree data structure along with utility methods

 * to make it useful.

 */

public class BinaryTree {

	public Node root;

	public BinaryTree() {

		root = null;

	}

	public void insert(String newRecord) {
		root = subtreeInsert(root, newRecord);
	}

	private Node subtreeInsert(Node topNode, String newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (newRecord.compareTo(topNode.record) < 0) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}

	/*
	 * Methods to perform an in-order tree traversal. The inOrderSubtree method
	 * does all of the work, with inOrder serving as a wrapper method (see
	 * above).
	 */
	public void inOrder() {

		inOrderSubtree(root);

	}

	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}

	/*
	 * 
	 * Methods to perform a pre-order traversal.
	 * 
	 */

	public void preOrder() {
		preOrderSubtree(root);
	}

	private void preOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);
			preOrderSubtree(topNode.right);
		}
	}

	/*
	 * Methods to perform a post-order traversal.
	 */
	public void postOrder() {
		postOrderSubtree(root);
	}

	private void postOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			postOrderSubtree(topNode.left);
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
		}
	}

	/*
	 * Methods to calculate the size (number of nodes) in a tree.
	 */
	public int size() {
		return subtreeSize(root);
	}

	private int subtreeSize(Node topNode) {
		if (topNode == null) {
			return 0;
		} else if(topNode.left == null && topNode.right == null) {
			return 1;
		} else {
			return subtreeSize(topNode.left) + subtreeSize(topNode.right) + 1;
		}
	}

	/*
	 * 
	 * Methods to calculate the maximum depth of a tree.
	 * 
	 */

	public int maxDepth() {

		return subtreeMaxDepth(root);

	}

	private int subtreeMaxDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else if(topNode.left == null && topNode.right == null) {
			return 1;
		} else {
			return subtreeMaxDepth(topNode.left) + subtreeMaxDepth(topNode.right);
		}
	}
	public int countMatches(String key) {
		return subtreeCountMatches(root, key);
	}
	private int subtreeCountMatches(Node topNode, String key) {
		if(topNode == null) {
			return 0;
		} else if(topNode.left == null && topNode.right == null && topNode.record.equals(key)) {
			return 1;
		} else if(topNode.left != null && topNode.right != null && topNode.record.equals(key)) {
			return subtreeCountMatches(topNode.left, key) + subtreeCountMatches(topNode.right, key) + 1;
		} else {
			return subtreeCountMatches(topNode.left, key) + subtreeCountMatches(topNode.right, key);
		}
	}
	public String maxRecord() {
		return max(root);
	}
	private String max(Node topNode) {
		if(topNode.equals(null)) {
			return null;
		}  else if(topNode.right.equals(null)) {
			return topNode.record;
		} else {
			return max(topNode.right);
		}
	}
	public String minRecord() {
		return min(root);
	}
	private String min(Node topNode) {
		if(topNode == null) {
			return topNode.record;
		} else if(topNode.left == null) {
			return topNode.record;
		} else {
			return min(topNode.left);
		}
	}
}