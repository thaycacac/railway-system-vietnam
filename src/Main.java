
import java.awt.BasicStroke;
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
        "TTHN Quốc Gia", "La Khê", "Ga Hà Nội", "Gia Lâm", "Vành đai 3.5",
        "Yên Nghĩa", "Hà Đông", "Thượng Đình", "Kim Liên", "Pháp Vân",
        "Ga Ngọc Hồi", "Dương Xá", "Nhổn"};
    
    int V, INF;
    ArrayList<Pair> vertexList;
    ArrayList<ArrayList<Pair>> adjList;
    ArrayList<Pair> station;
    int n = 34;
    double[][] W = new double[n][n];
    double[][] P = new double[n][n];
    double[][] D = new double[n][n];
    
    public Main() {
        initComponents();
        V = 0;
        INF = 9999999;
        vertexList = new ArrayList<Pair>();
        adjList = new ArrayList<ArrayList<Pair>>();
        station = new ArrayList<Pair>();
        btnFind.setEnabled(false);
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
        insertStation(246, 425, stationList[25]);
        insertStation(315, 604, stationList[26]);
        insertStation(427, 571, stationList[27]);
        insertStation(491, 531, stationList[28]);
        insertStation(676, 541, stationList[29]);
        insertStation(715, 585, stationList[30]);
        insertStation(656, 639, stationList[31]);
        insertStation(959, 620, stationList[32]);
        insertStation(479, 313, stationList[33]);
    }
    
    public void initMap() {
        //1.trung gia
        insertWeight(0, 7, 11.4);

        //2.sb noi bai
        insertWeight(1, 3, 12.1);
        insertWeight(1, 7, 4.1);

        //3.me linh
        insertWeight(2, 5, 9.7);

        //4.hai boi
        insertWeight(3, 8, 10.2);
        insertWeight(3, 5, 17.6);
        insertWeight(3, 4, 9.1);

        //5.vinh ngoc
        insertWeight(4, 24, 26.3);
        insertWeight(4, 7, 8.4);
        insertWeight(4, 12, 13);

        //6.tây tựu
        insertWeight(5, 15, 17);
        insertWeight(5, 6, 4.1);
        insertWeight(5, 33, 3.3);

        //7.lien ha
        //8.phu minh
        //9.phu dien
        insertWeight(8, 11, 3.3);
        insertWeight(8, 33, 2.2);
        insertWeight(8, 10, 2.1);
        insertWeight(8, 17, 4.2);

        //10.hoai duc
        insertWeight(9, 10, 5.6);
        insertWeight(9, 14, 5.7);

        //11.phuong canh
        insertWeight(10, 33, 0.8);
        insertWeight(10, 25, 4);

        //12.dai hoc quoc gia
        insertWeight(11, 21, 3.8);

        //13.van cao
        insertWeight(12, 29, 9.1);
        insertWeight(12, 16, 1.2);

        //14.yen thuong
        insertWeight(13, 24, 6.5);

        //15.vanh dai 3
        insertWeight(14, 22, 6.1);
        insertWeight(14, 30, 5.2);
        insertWeight(14, 28, 1);
        insertWeight(14, 21, 1.9);

        //16.chua ha
        insertWeight(15, 16, 2.6);
        insertWeight(15, 19, 2.7);

        //17.kim ma
        insertWeight(16, 20, 1.5);
        insertWeight(16, 19, 2.5);

        //18.tay mo
        insertWeight(17, 21, 5.4);
        insertWeight(17, 25, 1);

        //19.duong noi
        insertWeight(18, 27, 7.6);
        insertWeight(18, 22, 5.1);
        insertWeight(18, 25, 1.7);

        //20.tran duy hung
        insertWeight(19, 16, 2.5);
        insertWeight(19, 28, 4.4);
        insertWeight(19, 21, 1);

        //21.cat linh
        insertWeight(20, 28, 4.2);

        //22.trung tam hoi nghi quoc gia
        //23.la khe
        insertWeight(22, 27, 1.1);
        insertWeight(22, 26, 2.8);

        //24.ga ha noi
        insertWeight(23, 24, 7.8);
        insertWeight(23, 29, 1.9);

        //25.gia lam
        insertWeight(24, 32, 10.4);
        insertWeight(24, 28, 32.4);

        //26.vanh dai 3.5
        //27.yen nghia
        //28.ha dong
        insertWeight(27, 31, 11);

        //29.thuong dinh
        insertWeight(28, 29, 3.8);

        //30.kim lien
        insertWeight(29, 30, 4.8);

        //31.phap van
        insertWeight(30, 31, 4.9);
        //32.ga ngoc hoi
        //33.duong xa
        //34.nhon
    }
    
    public void shortestPath(int formFind, int toFind) {
        Graphics g = getGraphics();
        int width = 15, height = 15;
        int i = 0;
        for (int p = 0; p < n; p++) {
            for (int j = 0; j < n; j++) {
                P[i][j] = 0;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int p = 0; p < n; p++) {
                for (int j = 0; j < n; j++) {
                    if (D[p][k] + D[k][j] < D[p][j]) {
                        D[p][j] = D[p][k] + D[k][j];
                        P[p][j] = k;
                    }
                }
            }
        }
        while (i < adjList.size()) {
            Iterator itr = adjList.get(i).iterator();
            Pair pcor = vertexList.get(i);
            int x = (int) pcor.getx();
            int y = (int) pcor.gety();
            while (itr.hasNext()) {
                Pair p = (Pair) itr.next();
                Pair pcor1 = vertexList.get((int) p.getx());
                int x1 = (int) pcor1.getx();
                int y1 = (int) pcor1.gety();
                g.setColor(Color.GRAY);
                g.drawLine(x + width / 2, y + height / 2, x1 + width / 2, y1 + width / 2);
            }
            i++;
        }
        //draw station visited
        for (i = 0; i < vertexList.size(); i++) {
            Pair p = vertexList.get(i);
            int x = (int) p.getx();
            int y = (int) p.gety();
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
            int u = (int) p.gety();
            if (doneWith[u]) {
                continue;
            }
            doneWith[u] = true;
            Iterator itr = adjList.get(u).iterator();
            while (itr.hasNext()) {
                Pair pr = (Pair) itr.next();
                int v = (int) pr.getx();
                int weight = (int) pr.gety();
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
        int x = (int) p.getx();
        int y = (int) p.gety();
        int width = 15, height = 15;
        Graphics g = getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(x, y, width, height);
        g.setColor(Color.YELLOW);
        g.drawOval(x, y, width, height);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        g.drawString(stationList[vertex], x - 10, y + 25);
    }
    
    public void invertEdge(int vertex, int par) {
        int width = 15, height = 15;
        Graphics g = getGraphics();
        Pair p = vertexList.get(vertex);
        int x = (int) p.getx();
        int y = (int) p.gety();
        g.setColor(Color.RED);
        Pair p1 = vertexList.get(par);
        int x1 = (int) p1.getx();
        int y1 = (int) p1.gety();
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
    
    void insertWeight(int from, int to, double weight) {
        //check weight valid or not
        int width = 15, height = 15;
        int x1 = (int) vertexList.get(from).getx();
        int y1 = (int) vertexList.get(from).gety();
        int x2 = (int) vertexList.get(to).getx();
        int y2 = (int) vertexList.get(to).gety();
        Graphics g = getGraphics();
        int midx = (x1 + x2) / 2;
        int midy = (y1 + y2) / 2;

        //draw line
        g.setColor(Color.gray);
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
        g.drawString(new Double(weight).toString(), midx - 5, midy);
        adjList.get(from).add(new Pair(to, weight));
        adjList.get(to).add(new Pair(from, weight));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbFloyd1 = new javax.swing.JLabel();
        jlbTo1 = new javax.swing.JLabel();
        jlbFrom1 = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        chbFrom = new javax.swing.JComboBox<>();
        chbTo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
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

        jlbFloyd1.setForeground(new java.awt.Color(0, 0, 255));
        jlbFloyd1.setText("FLOYD ALGORITHM");

        jlbTo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTo1.setText("To:");

        jlbFrom1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbFrom1.setText("From:");

        btnFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFind.setForeground(new java.awt.Color(51, 51, 255));
        btnFind.setText("FIND");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnDisplay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDisplay.setForeground(new java.awt.Color(0, 102, 153));
        btnDisplay.setText("SHOW MAPS");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        chbFrom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chbFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trung Giã", "SB Nội Bài", "Mê Linh", "Hải Bối", "Vĩnh Ngọc", "Tây Tựu", "Niên Hà", "Phú Minh", "Phú Diễn", "Hoài Đức", "Phương Canh", "ĐH Quốc Gia", "Văn Cao", "Yên Thường", "Vành đai 3", "Chùa Hà", "Kim Mã", "Tây Mỗ", "Dương Nội", "Trần Duy Hưng", "Cát Linh", "TTHN Quốc Gia", "La Khê", "Ga Hà Nội", "Gia Lâm", "Vành đai 3.5", "Yên Nghĩa", "Hà Đông", "Thượng Đình", "Kim Liên", "Pháp Vân", "Ga Ngọc Hồi", "Dương Xá", "Nhổn" }));

        chbTo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chbTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trung Giã", "SB Nội Bài", "Mê Linh", "Hải Bối", "Vĩnh Ngọc", "Tây Tựu", "Niên Hà", "Phú Minh", "Phú Diễn", "Hoài Đức", "Phương Canh", "ĐH Quốc Gia", "Văn Cao", "Yên Thường", "Vành đai 3", "Chùa Hà", "Kim Mã", "Tây Mỗ", "Dương Nội", "Trần Duy Hưng", "Cát Linh", "TTHN Quốc Gia", "La Khê", "Ga Hà Nội", "Gia Lâm", "Vành đai 3.5", "Yên Nghĩa", "Hà Đông", "Thượng Đình", "Kim Liên", "Pháp Vân", "Ga Ngọc Hồi", "Dương Xá", "Nhổn" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jlbFloyd1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chbTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jlbFrom1)
                                        .addComponent(chbFrom, 0, 190, Short.MAX_VALUE)
                                        .addComponent(jlbTo1)
                                        .addComponent(btnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jlbFloyd1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbFrom1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbTo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbTo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(439, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        //add to adj list
//        adjList.add(new ArrayList<Pair>());
//        
//        Integer i = new Integer(V);
//        int x = evt.getX();
//        int y = evt.getY();
//        System.out.println(x);
//        System.out.println(y);
//        
//        vertexList.add(new Pair(x, y));
//        int width = 15, height = 15;
//        String text = i.toString();
//        Graphics g = getGraphics();
//        g.setColor(Color.YELLOW);
//        g.fillOval(x, y, width, height);
//        g.setColor(Color.BLACK);
//        g.drawOval(x, y, width, height);
//        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
//        //set text and index
//        g.drawString(text, x - 15, y + 20);
//        V++;
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        int fromFind = chbFrom.getSelectedIndex();
        int toFind = chbTo.getSelectedIndex();
        //check input find valid or not
        shortestPath(fromFind, toFind);
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        initState();
        initMap();
        btnFind.setEnabled(true);
    }//GEN-LAST:event_btnDisplayActionPerformed

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
                if ("Windows".equals(info.getName())) {
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
        
        double x, y;
        
        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        public double getx() {
            return x;
        }
        
        public double gety() {
            return y;
        }
    }
    
    class MyComparator implements Comparator<Pair> {
        
        public int compare(Pair a, Pair b) {
            return (new Double(a.getx())).compareTo(new Double(b.getx()));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnFind;
    private javax.swing.JComboBox<String> chbFrom;
    private javax.swing.JComboBox<String> chbTo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbFloyd1;
    private javax.swing.JLabel jlbFrom1;
    private javax.swing.JLabel jlbTo1;
    // End of variables declaration//GEN-END:variables
}
