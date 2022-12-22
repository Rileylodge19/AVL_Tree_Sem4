package com.keyin.tree;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class TestAvlTree {

    @Mock
    private static AVLTree mockNode;

    @Test
    public void testingAvlTree() {
        AVLTree tree = new AVLTree();
        tree.root = tree.insertNode(tree.root, 12);
        tree.root = tree.insertNode(tree.root, 2);
        tree.root = tree.insertNode(tree.root, 14);
        tree.root = tree.insertNode(tree.root, 11);
        tree.root = tree.insertNode(tree.root, 7);
        tree.root = tree.insertNode(tree.root, 9);
        tree.root = tree.insertNode(tree.root, 13);
        tree.root = tree.insertNode(tree.root, 3);
        Node node = new Node(19);
        Assertions.assertEquals(19, node.item);
        Assertions.assertEquals(4, tree.height(tree.root));
        Assertions.assertNotNull(tree.root);
        Assertions.assertEquals(1, tree.getBalanceFactor(tree.root));
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        ArrayList<Integer> numbersInput = new ArrayList<Integer>();
        try {
            File myData = new File("data.txt");
            if (myData.createNewFile()) {
                System.out.println("File created: " + myData.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < 8; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a number: ");
            int inputNum = scanner.nextInt();
            tree.root = tree.insertNode(tree.root, inputNum);
            numbersInput.add(inputNum);
            try {
                FileWriter myWriter = new FileWriter("data.txt");
                myWriter.write("Inputted Numbers = " + numbersInput);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            tree.printTree(tree.root, "", true);
        }
    }
}
