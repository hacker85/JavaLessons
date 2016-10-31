package swing.adwanced;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by husiv on 10/25/16.
 */
public class TreeLesson {
    public static void main(String[] args) {
        JFrame jFrame = getFrame();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Countries");

        DefaultMutableTreeNode europe = new DefaultMutableTreeNode("Europe");
        DefaultMutableTreeNode france = new DefaultMutableTreeNode("France");
        europe.add(france);

        DefaultMutableTreeNode usa = new DefaultMutableTreeNode("USA");
        root.add(europe);
        root.add(usa);

        DefaultTreeModel model = new DefaultTreeModel(root);
        JTree jTree = new JTree(model);

        jTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TreePath path = jTree.getSelectionPath();
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)path.getLastPathComponent();
                if(selectedNode.isLeaf()) {
                    System.out.println(selectedNode.getUserObject().toString());
                }
            }
        });

        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.add(jTree);

        jFrame.revalidate();
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setBounds(500, 250, 500, 500);
        return jFrame;
    }
}
