package com.szh.algorithm.datastruct;

public class TestTree {



    private static class TreeNodeTest{

        private TreeNodeTest left;

        private TreeNodeTest right;

        private int self;


        public TreeNodeTest(TreeNodeTest left, TreeNodeTest right, int self) {
            this.left = left;
            this.right = right;
            this.self = self;
        }

        public TreeNodeTest(int self) {
           this(null,null,self);
        }

        void insertRight(int value){
            if(this.right != null){
                this.right.right = new TreeNodeTest(value);
            }else{
                this.right = new TreeNodeTest(value);
            }

        }

        void insertLeft(int value){
            if(this.left != null){
                this.left.left = new TreeNodeTest(value);
            }else{
                this.left = new TreeNodeTest(value);
            }

        }

        public TreeNodeTest getLeft() {
            return left;
        }

        public void setLeft(TreeNodeTest left) {
            this.left = left;
        }

        public TreeNodeTest getRight() {
            return right;
        }

        public void setRight(TreeNodeTest right) {
            this.right = right;
        }

        public int getSelf() {
            return self;
        }

        public void setSelf(int self) {
            this.self = self;
        }
    }


    public static void main(String[] args) {
        //init a root node;
        TreeNodeTest treeNodeTest = new TreeNodeTest(1);

        treeNodeTest.insertRight(2);
        treeNodeTest.insertRight(3);


        System.out.println(treeNodeTest);
    }



}
