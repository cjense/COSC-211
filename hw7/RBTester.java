import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class RBTester {

    public static void main (String[] args) {

	if (args.length != 1) { showUsageAndExit(); }

	RedBlackTree<Integer> rbt = new RedBlackTree<Integer>();
	Scanner                sc = null;
        try {
            sc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            System.err.printf("ERROR: Could not open file %s\n", args[0]);
            System.exit(1);
        }

	// Read instructions until there are no more.
	int line = 0;
	while (sc.hasNext()) {

	    line = line + 1;
	    int    value = 0;
	    try {
		value = sc.nextInt();
	    } catch (InputMismatchException e) {
		System.err.printf("ERROR: Could not read value on line %d\n", line);
		System.exit(1);
	    }
            String  color = sc.next();
            boolean red   = false;;
            if (color.equalsIgnoreCase("red")) {
                red = true;
            } else if (!color.equalsIgnoreCase("black")) {
                System.err.printf("ERROR: Unknown color %s on line %d\n", color, line);
                System.exit(1);
            }
            
            rbt.insert(value, red);
            
	}

        System.out.printf("Is it valid? %b\n", isRBTree(rbt));

    }

    
    private static void showUsageAndExit () {
	
	System.err.printf("USAGE: java RBTester <input pathname>\n");
	System.exit(1);

    }

    private static boolean rootChecker(RedBlackTree<Integer> rbt) {
        RBNode<Integer> root = rbt.root;

        if(!root.red) {
            System.out.println("root is valid");
            return true;
        } else {
            System.out.println("root is not valid");
            return false;
        }
    }

    private static boolean nullLeafChecker(RBNode<Integer> node) {
        // checks if null leaves are black
        if(node.isNullLeaf() && !node.red) {
            System.out.println("leaf is black");
            return true;
        } else if(node.isNullLeaf() && node.red) {
            System.out.println("leaf is red");
            return false;
        }

        return false;
    }

    private static boolean isValidParent(RBNode<Integer> node) {
        // checks if red parent has black children
        if(node.red) {
            if(!node.left.red && !node.right.red) {
                System.out.println("red parent has black children");
                return true;
            } else {
                System.out.println("red parent doesn't have black children");
                return false;
            }
        }

        return true;
    }

    private static int blackHeight(RBNode<Integer> node) {
        int count = 0;

        if (node == null) {
            return 0;
        }

        if(!isValidParent(node)) {
            System.out.println("not valid parent");
            return 0;
        }

        if(nullLeafChecker(node)) {
            System.out.println("valid null leaf");
            return 1;
        }

        if(!node.red) {
            count++;
            System.out.println("increasing count to: " + count);
        }

        int leftHeight = blackHeight(node.left) + count;
        int rightHeight = blackHeight(node.right) + count;

        // if the left height is equal to the right height, and they are > 0, return count
        if(leftHeight != rightHeight) {
            return 0;
        } else {
            return leftHeight;
        }

    }

    private static boolean isRBTree (RedBlackTree<Integer> rbt) {
        RBNode<Integer> root = rbt.root;

        if(!rootChecker(rbt)) {
            return false;
        }

        return blackHeight(root) > 0;
    }
} // class RBTest
