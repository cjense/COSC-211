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

    private static boolean inOrder(RedBlackTree<Integer> rbt, RBNode<Integer> node) {
        RBNode<Integer> root = rbt.root;
        node = root;

        if (node.red && node.left.red != true && node.right.red != true) {
            return false;
        }

        if(node.left != null && node.right != null) {
            inOrder(rbt, node.left);
            inOrder(rbt, node.right);
        }

        return true;

    }

    private static boolean rootChecker(RedBlackTree<Integer> rbt) {
        RBNode<Integer> root = rbt.root;

        if(root.red != false) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean nullLeafChecker(RedBlackTree<Integer> rbt) {


        return false;
    }

    private static boolean redChildren(RedBlackTree<Integer> rbt) {

        RBNode<Integer> root = rbt.root;
        RBNode<Integer> left = root.left;
        RBNode<Integer> right = root.right;

        // go through left side of tree to check for red nodes' children
        while(left != null) {
            if(left.red) {
                if(left.right.red != true && left.left.red != true) {
                    left = left.left;
                } else { return false; }
            } else {
                left = left.left;
            }
        }

        while(right != null) {

        }

        if(count == 2) {
            return true;
        } else {
            return false;
        }

        return false;
    }

    private static boolean blackTraverse(RedBlackTree<Integer> rbt) {


        return false;
    }


    private static boolean isRBTree (RedBlackTree<Integer> rbt) {

        if(rootChecker(rbt) && nullLeafChecker(rbt) && redChildren(rbt) && blackTraverse(rbt)) {
            return true;
        } else {
            return false;
        }

    }


} // class RBTest
