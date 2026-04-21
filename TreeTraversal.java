

/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/

//---------------------------in order
class Solution {
    
    
    public static void inOrderTrav(Node root, ArrayList<Integer> res){
        if(root == null){
            return;
        }
        inOrderTrav(root.left, res);
        res.add(root.data);
        inOrderTrav(root.right,res);
        
    }
    
public ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res=new ArrayList<>();
        
        inOrderTrav(root, res);
        return res;
    }
}


 //---------------------------pre order
class Solution {
    
    public static void preOrderTrav(Node root, ArrayList<Integer> res){
        if(root==null){
            return;
        }
        res.add(root.data);
        preOrderTrav(root.left, res);
        preOrderTrav(root.right, res);
    }
    
    
    
    public ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> res= new ArrayList<>();
        preOrderTrav(root,res);
        return res;
    }
}



//---------------------------post order
class Solution {
    public static void postOrderTrav(Node root, ArrayList<Integer> res){
        if(root==null){
            return;
        }
        postOrderTrav(root.left, res);
        postOrderTrav(root.right, res);
        res.add(root.data);
    }
    
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> res= new ArrayList<>();
        postOrderTrav(root, res);
        return res;
    }
}



//__________________________________level by order (bfs)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();

        if (root == null) {
            return res;
        }

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {

            //1
            TreeNode currNode = q.remove();

            //2
            if (currNode == null) {
                res.add(new ArrayList<>(row));
                row.clear();

                if (q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }

            } else { //3

                row.add(currNode.val);

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }

            }

        }

        return res;
    }
}