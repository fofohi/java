package com.szh.algorithm.datastruct;


import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunzhuhuan Administrator on 2017/9/29.
 */
public class ManyTreeStruct {


    public void binaryTree(){
        TreeNode tn = new TreeNode("parent");
        TreeNode tnChild1 = new TreeNode("child1");
        TreeNode tnChild2 = new TreeNode("child2");
        TreeNode tnChild3 = new TreeNode("child3");
        TreeNode tnChild4 = new TreeNode("child4");
        TreeNode tnChildChild1 = new TreeNode("childchild1");
        TreeNode tnChildChild2 = new TreeNode("childchild2");
        TreeNode tnChildChildChild1 = new TreeNode("childchildchild1");
        tn.addNodeList(tnChild1);
        tn.addNodeList(tnChild2);
        tn.addNodeList(tnChild3);
        tn.addNodeList(tnChild4);
        tnChild1.addNodeList(tnChildChild1);
        tnChild2.addNodeList(tnChildChild2);
        tnChildChild1.addNodeList(tnChildChildChild1);


        Stack<List<TreeNode>> stack = new Stack<>();

        if (tn.getChildNode().size() > 0){
            List<TreeNode> tr = tn.getChildNode();
            for (TreeNode treeNode : tr) {
                System.out.println(treeNode.getNodeName());
                if(treeNode.getChildNode().size() > 0){
                    stack.push(treeNode.getChildNode());
                    while (!stack.empty()){
                        List<TreeNode> trs = stack.pop();
                        for (TreeNode node : trs) {
                            System.out.println(node.getNodeName());
                            if(node.getChildNode().size() > 0){
                                stack.push(node.getChildNode());
                            }
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        new ManyTreeStruct().binaryTree();
    }


    private class TreeNode{
        private List<TreeNode> childNode = new ArrayList<>();
        private String nodeName;
        public TreeNode(String node){
            this.nodeName = node;
        }

        public void addNodeList(TreeNode treeNode){
            this.childNode.add(treeNode);
        }

        public List<TreeNode> getChildNode() {
            return childNode;
        }

        public String getNodeName(){
            return nodeName;
        }
    }


}
