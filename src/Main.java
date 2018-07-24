
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author Thaycacac
 */
public class Main extends javax.swing.JFrame {
    
    String[] stationList = {"Trung Giã", "SB Nội Bài", "Mê Linh", "Hải Bối",
        "Vĩnh Ngọc", "Tây Tựu", "Niên Hà", "Phú Minh", "Phú Diễn", "Hoài Đức",
        "Phương Canh", "ĐH Quốc Gia", "Văn Cao", "Yên Thường", "Vành đai 3",
        "Chùa Hà", "Kim Mã", "Tây Mỗ", "Dương Nội", "Trần Duy Hưng", "Cát Linh",
        "TTHN Quốc Gia", "La Khê", "Ga Hà Nội", "Gia Lâm", "Chương Mỹ",
        "Yên Nghĩa", "Hà Đông", "Thượng Đình", "Kim Liên", "Pháp Vân",
        "Ga Ngọc Hồi", "Dương Xá", "Nhổn"};
    
    int V, INF;
    ArrayList<Pair> vertexList;
    ArrayList<ArrayList<Pair>> adjList;
    ArrayList<Pair> station;
    
    public Main() {
        initComponents();
        V = 0;
        INF = 9999999;
        vertexList = new ArrayList<Pair>();
        adjList = new ArrayList<ArrayList<Pair>>();
        station = new ArrayList<Pair>();
    }
    
    public void initState() {
        insertStation(779, 45, stationList[0]);
        insertStation(630, 65, stationList[1]);
        insertStation(523, 121, stationList[2]);
        insertStation(694, 117, stationList[3]);
        insertStation(741, 153, stationList[4]);
        insertStation(354, 194, stationList[5]);
        insertStation(832, 213, stationList[6]);
        insertStation(420, 257, stationList[7]);
        insertStation(471, 275, stationList[8]);
        insertStation(214, 318, stationList[9]);
        insertStation(361, 354, stationList[10]);
        insertStation(515, 333, stationList[11]);
        insertStation(649, 340, stationList[12]);
        insertStation(997, 317, stationList[13]);
        insertStation(410, 393, stationList[14]);
        insertStation(576, 375, stationList[15]);
        insertStation(662, 385, stationList[16]);
        insertStation(283, 506, stationList[17]);
        insertStation(432, 471, stationList[18]);
        insertStation(502, 466, stationList[19]);
        insertStation(708, 434, stationList[20]);
        insertStation(471, 489, stationList[21]);
        insertStation(535, 496, stationList[22]);
        insertStation(814, 486, stationList[23]);
        insertStation(997, 460, stationList[24]);
        insertStation(213, 628, stationList[25]);
        insertStation(315, 604, stationList[26]);
        insertStation(427, 571, stationList[27]);
        insertStation(491, 531, stationList[28]);
        insertStation(676, 541, stationList[29]);
        insertStation(715, 585, stationList[30]);
        insertStation(656, 639, stationList[31]);
        insertStation(959, 620, stationList[32]);
    }
    
    public void initMap() {
        
    }
    
    public void shortestPath(int formFind, int toFind) {
        Graphics g = getGraphics();
        int width = 15, height = 15;
        int i = 0;
        //draw station visited
        for (i = 0; i < vertexList.size(); i++) {
            Pair p = vertexList.get(i);
            int x = p.getx();
            int y = p.gety();
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, width, height);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, width, height);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
            g.drawString((new Integer(i)).toString(), x - 10, y + 25);
        }
        
        int[] dist = new int[V];
        int[] parent = new int[V];
        boolean[] doneWith = new boolean[V];
        for (i = 0; i < V; i++) {
            dist[i] = INF;
            doneWith[i] = false;
            parent[i] = -1;
        }
        dist[formFind] = 0;
        
        Comparator<Pair> comparator = new MyComparator();
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(comparator);
        
        q.add(new Pair(0, formFind));
        
        while (q.size() != 0) {
            Pair p = q.poll();
            int u = p.gety();
            if (doneWith[u]) {
                continue;
            }
            doneWith[u] = true;
            Iterator itr = adjList.get(u).iterator();
            while (itr.hasNext()) {
                Pair pr = (Pair) itr.next();
                int v = pr.getx();
                int weight = pr.gety();
                if (!doneWith[v] && dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    q.add(new Pair(dist[v], v));
                }
            }
        }
        printParentEdges(toFind, parent);
        printParent(toFind, parent);
    }
    
    public void invertNode(int vertex) {
        Pair p = vertexList.get(vertex);
        int x = p.getx();
        int y = p.gety();
        int width = 15, height = 15;
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLUE);
        g.drawOval(x, y, width, height);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        g.drawString((new Integer(vertex)).toString(), x - 15, y + 20);
    }
    
    public void invertEdge(int vertex, int par) {
        int width = 15, height = 15;
        Graphics g = getGraphics();
        Pair p = vertexList.get(vertex);
        int x = p.getx();
        int y = p.gety();
        g.setColor(Color.RED);
        Pair p1 = vertexList.get(par);
        int x1 = p1.getx();
        int y1 = p1.gety();
        g.drawLine(x + width / 2, y + height / 2, x1 + width / 2, y1 + width / 2);
    }
    
    public void printParentEdges(int vertex, int[] parent) {
        if (parent[vertex] == -1) {
            return;
        }
        printParentEdges(parent[vertex], parent);
        invertEdge(vertex, parent[vertex]);
    }
    
    public void printParent(int vertex, int[] parent) {
        if (parent[vertex] == -1) {
            invertNode(vertex);
            return;
        }
        printParent(parent[vertex], parent);
        invertNode(vertex);
    }
    
    public void insertStation(int x, int y, String stationName) {
        adjList.add(new ArrayList<Pair>());
        Integer i = new Integer(V);
        vertexList.add(new Pair(x, y));
        int width = 15, height = 15;
        String text = i.toString();
        Graphics g = getGraphics();
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        //set text and index
        g.drawString(stationName, x - 10, y + 25);
        V++;
    }
    
    void insertWeight(int from, int to, int weight) {
        //check weight valid or not
        if (weight < 0 || to > vertexList.size()
                || from > vertexList.size() || to < 0 || from < 0) {
            tfFrom.setText("INVALID");
            tfTo.setText("INVALID");
            tfWeight.setText("INVALID");
            return;
        }
        int width = 15, height = 15;
        tfFrom.setText("");
        tfTo.setText("");
        tfWeight.setText("");
        int x1 = vertexList.get(from).getx();
        int y1 = vertexList.get(from).gety();
        int x2 = vertexList.get(to).getx();
        int y2 = vertexList.get(to).gety();
        Graphics g = getGraphics();
        int midx = (x1 + x2) / 2;
        int midy = (y1 + y2) / 2;

        //draw line
        g.drawLine(x1 + width / 2, y1 + height / 2, x2 + width / 2, y2 + width / 2);

        //draw node 1
        g.setColor(Color.YELLOW);
        g.fillOval(x1, y1, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x1, y1, width, height);
        //draw node 2
        g.setColor(Color.YELLOW);
        g.fillOval(x2, y2, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x2, y2, width, height);
        //draw weight
        g.drawString(new Integer(weight).toString(), midx - 5, midy);
        adjList.get(from).add(new Pair(to, weight));
        adjList.get(to).add(new Pair(from, weight));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbFloyd = new javax.swing.JLabel();
        jlbFrom = new javax.swing.JLabel();
        jlbTo = new javax.swing.JLabel();
        tfTo = new javax.swing.JTextField();
        jlbWeight = new javax.swing.JLabel();
        tfFrom = new javax.swing.JTextField();
        tfWeight = new javax.swing.JTextField();
        jlbFloyd1 = new javax.swing.JLabel();
        tfFromFind = new javax.swing.JTextField();
        tfToFind = new javax.swing.JTextField();
        jlbTo1 = new javax.swing.JLabel();
        jlbFrom1 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        btnFind2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jlbFloyd.setForeground(new java.awt.Color(0, 0, 255));
        jlbFloyd.setText("ADD EDGE");

        jlbFrom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbFrom.setText("From");

        jlbTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTo.setText("To");

        tfTo.setText("1");

        jlbWeight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbWeight.setText("Weight");

        tfFrom.setText("0");

        tfWeight.setText("12");

        jlbFloyd1.setForeground(new java.awt.Color(0, 0, 255));
        jlbFloyd1.setText("FLOYD ALGORITHM");

        jlbTo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTo1.setText("To");

        jlbFrom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbFrom1.setText("From");

        btnFind.setForeground(new java.awt.Color(51, 0, 255));
        btnFind.setText("FIND");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnAdd.setForeground(new java.awt.Color(51, 0, 255));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDisplay.setText("Display");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        btnFind2.setText("Find2");
        btnFind2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFind2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbFrom)
                        .addGap(18, 18, 18)
                        .addComponent(tfFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbWeight)
                        .addGap(6, 6, 6)
                        .addComponent(tfWeight))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbTo)
                        .addGap(34, 34, 34)
                        .addComponent(tfTo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbFrom1)
                        .addGap(18, 18, 18)
                        .addComponent(tfFromFind, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbTo1)
                        .addGap(34, 34, 34)
                        .addComponent(tfToFind))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbFloyd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbFloyd1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFind, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDisplay, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnFind2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jlbFloyd)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFrom)
                    .addComponent(tfFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTo)
                    .addComponent(tfTo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbWeight)
                    .addComponent(tfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addGap(41, 41, 41)
                .addComponent(jlbFloyd1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFrom1)
                    .addComponent(tfFromFind, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTo1)
                    .addComponent(tfToFind, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFind)
                .addGap(18, 18, 18)
                .addComponent(btnDisplay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFind2)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        //add to adj list
        adjList.add(new ArrayList<Pair>());
        
        Integer i = new Integer(V);
        int x = evt.getX();
        int y = evt.getY();
        System.out.println(x);
        System.out.println(y);
        
        vertexList.add(new Pair(x, y));
        int width = 15, height = 15;
        String text = i.toString();
        Graphics g = getGraphics();
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        //set text and index
        g.drawString(text, x - 15, y + 20);
        V++;
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //get value
        int from = Integer.valueOf(tfFrom.getText());
        int to = Integer.valueOf(tfTo.getText());
        int weight = Integer.valueOf(tfWeight.getText());
        //check weight valid or not
        if (weight < 0 || to > vertexList.size()
                || from > vertexList.size() || to < 0 || from < 0) {
            tfFrom.setText("INVALID");
            tfTo.setText("INVALID");
            tfWeight.setText("INVALID");
            return;
        }
        int width = 15, height = 15;
        tfFrom.setText("");
        tfTo.setText("");
        tfWeight.setText("");
        int x1 = vertexList.get(from).getx();
        int y1 = vertexList.get(from).gety();
        int x2 = vertexList.get(to).getx();
        int y2 = vertexList.get(to).gety();
        Graphics g = getGraphics();
        int midx = (x1 + x2) / 2;
        int midy = (y1 + y2) / 2;

        //draw line
        g.drawLine(x1 + width / 2, y1 + height / 2, x2 + width / 2, y2 + width / 2);

        //draw node 1
        g.setColor(Color.YELLOW);
        g.fillOval(x1, y1, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x1, y1, width, height);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        g.drawString(new Integer(from).toString(), x1 - 15, y1 + 20);
        //draw node 2
        g.setColor(Color.YELLOW);
        g.fillOval(x2, y2, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x2, y2, width, height);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        g.drawString(new Integer(to).toString(), x2 - 15, y2 + 20);
        //draw weight
        g.drawString(new Integer(weight).toString(), midx - 5, midy);
        adjList.get(from).add(new Pair(to, weight));
        adjList.get(to).add(new Pair(from, weight));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        int fromFind = Integer.valueOf(tfFromFind.getText());
        int toFind = Integer.valueOf(tfToFind.getText());
        //check input find valid or not
        if (fromFind < 0 || fromFind > V || toFind < 0 || toFind > V) {
            tfFromFind.setText("INVALID");
            tfToFind.setText("INVALID");
        }
        shortestPath(fromFind, toFind);
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        initState();
        initMap();
    }//GEN-LAST:event_btnDisplayActionPerformed

    private void btnFind2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFind2ActionPerformed
        shortestPath(0, 3);
    }//GEN-LAST:event_btnFind2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    class Pair {
        
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getx() {
            return x;
        }
        
        public int gety() {
            return y;
        }
    }
    
    class MyComparator implements Comparator<Pair> {
        
        public int compare(Pair a, Pair b) {
            return (new Integer(a.getx())).compareTo(new Integer(b.getx()));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFind2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbFloyd;
    private javax.swing.JLabel jlbFloyd1;
    private javax.swing.JLabel jlbFrom;
    private javax.swing.JLabel jlbFrom1;
    private javax.swing.JLabel jlbTo;
    private javax.swing.JLabel jlbTo1;
    private javax.swing.JLabel jlbWeight;
    private javax.swing.JTextField tfFrom;
    private javax.swing.JTextField tfFromFind;
    private javax.swing.JTextField tfTo;
    private javax.swing.JTextField tfToFind;
    private javax.swing.JTextField tfWeight;
    // End of variables declaration//GEN-END:variables
}
