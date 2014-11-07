
public class Tree {
    
    public Tree left;
    public Tree right;
    public int value;
    public Tree(int v) {
        value = v;
    }

    public boolean  addBst(int x) {
        if(value == x) { return false; }
        else if (value < x) {
            if(this.left == null) {
                left = new Tree(x);
                return true;
            } else {
                return left.addBst(x);
            }

        }
        else if ( value > x ) {
            {
                if (this.right == null) {
                    right = new Tree(x);
                } else {
                    return right.addBst(x);
                }
            }
        }
        return false;
    }

    public static boolean isValidBST(Tree root) {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    
    public static boolean validate(Tree root, int min, int max) {
        if (root == null) {
            return true;
        }
        // not in range
        if (root.value <= min || root.value >= max) {
            return false;
        }
        // left subtree must be < root.value
        // && right subtree must be > root.value
        return validate(root.left, min, root.value)
                && validate(root.right, root.value, max);
    }
}
