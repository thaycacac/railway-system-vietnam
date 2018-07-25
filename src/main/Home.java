package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Admin
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
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
    
    public Home() {
        initComponents();
        ((JLabel)chbFrom.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)chbTo.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
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
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLUE);
        g.drawOval(x, y, width, height);
        g.setColor(Color.BLUE);
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

        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_exit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        button2 = new java.awt.Button();
        jlbFrom1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnFind = new java.awt.Button();
        jlbFrom = new javax.swing.JLabel();
        chbFrom = new javax.swing.JComboBox<>();
        jlbTo = new javax.swing.JLabel();
        chbTo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(71, 120, 197));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(123, 156, 225));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setPreferredSize(new java.awt.Dimension(2, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/icons8_Search_18px.png"))); // NOI18N

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/icons8_Exit_25px.png"))); // NOI18N
        btn_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_exitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(842, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(32, 32, 32)
                .addComponent(btn_exit)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 40));

        jPanel3.setBackground(new java.awt.Color(71, 120, 197));

        jPanel4.setBackground(new java.awt.Color(120, 168, 252));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(84, 127, 206));

        button2.setActionCommand("Show Maps");
        button2.setBackground(new java.awt.Color(71, 120, 197));
        button2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("Show Maps");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jlbFrom1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jlbFrom1.setForeground(new java.awt.Color(255, 255, 255));
        jlbFrom1.setText("Railway System Viet Nam");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbFrom1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addGap(24, 24, 24)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlbFrom1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 210, 160));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/icons8-vietnam-75.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 86, 80));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Thaycacac");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 30));

        btnFind.setActionCommand("SEARCH");
        btnFind.setBackground(new java.awt.Color(71, 120, 197));
        btnFind.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFind.setForeground(new java.awt.Color(255, 255, 255));
        btnFind.setLabel("SEARCH");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jlbFrom.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jlbFrom.setForeground(new java.awt.Color(255, 255, 255));
        jlbFrom.setText("From");

        chbFrom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chbFrom.setForeground(new java.awt.Color(71, 120, 197));
        chbFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trung Giã", "SB Nội Bài", "Mê Linh", "Hải Bối", "Vĩnh Ngọc", "Tây Tựu", "Niên Hà", "Phú Minh", "Phú Diễn", "Hoài Đức", "Phương Canh", "ĐH Quốc Gia", "Văn Cao", "Yên Thường", "Vành đai 3", "Chùa Hà", "Kim Mã", "Tây Mỗ", "Dương Nội", "Trần Duy Hưng", "Cát Linh", "TTHN Quốc Gia", "La Khê", "Ga Hà Nội", "Gia Lâm", "Vành đai 3.5", "Yên Nghĩa", "Hà Đông", "Thượng Đình", "Kim Liên", "Pháp Vân", "Ga Ngọc Hồi", "Dương Xá", "Nhổn" }));
        chbFrom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 255)));
        chbFrom.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        jlbTo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jlbTo.setForeground(new java.awt.Color(255, 255, 255));
        jlbTo.setText("To");

        chbTo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chbTo.setForeground(new java.awt.Color(71, 120, 197));
        chbTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trung Giã", "SB Nội Bài", "Mê Linh", "Hải Bối", "Vĩnh Ngọc", "Tây Tựu", "Niên Hà", "Phú Minh", "Phú Diễn", "Hoài Đức", "Phương Canh", "ĐH Quốc Gia", "Văn Cao", "Yên Thường", "Vành đai 3", "Chùa Hà", "Kim Mã", "Tây Mỗ", "Dương Nội", "Trần Duy Hưng", "Cát Linh", "TTHN Quốc Gia", "La Khê", "Ga Hà Nội", "Gia Lâm", "Vành đai 3.5", "Yên Nghĩa", "Hà Đông", "Thượng Đình", "Kim Liên", "Pháp Vân", "Ga Ngọc Hồi", "Dương Xá", "Nhổn" }));
        chbTo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(102, 102, 102), new java.awt.Color(204, 204, 255)));
        chbTo.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/icons8-marker-25.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlbTo)
                            .addComponent(chbFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbTo, 0, 0, Short.MAX_VALUE)
                            .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel5))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jlbFrom)
                    .addContainerGap(159, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(chbFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbTo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(chbTo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(236, 236, 236)
                    .addComponent(jlbFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(402, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 670));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 880, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int xx,xy;
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //drag this pane
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        
        //source to drag
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btn_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exitMousePressed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_btn_exitMousePressed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        int fromFind = chbFrom.getSelectedIndex();
        int toFind = chbTo.getSelectedIndex();
        //check input find valid or not
        shortestPath(fromFind, toFind);
    }//GEN-LAST:event_btnFindActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        initState();
        initMap();
        btnFind.setEnabled(true);
    }//GEN-LAST:event_button2ActionPerformed

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        //         adjList.add(new ArrayList<Pair>());
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
    }//GEN-LAST:event_jPanel6MouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
   
    
    private void setColor(JPanel pane)
    {
        pane.setBackground(new Color(41,57,80));
    }
    
    private void resetColor(JPanel [] pane, JPanel [] indicators)
    {
        for(int i=0;i<pane.length;i++){
           pane[i].setBackground(new Color(23,35,51));
           
        } for(int i=0;i<indicators.length;i++){
           indicators[i].setOpaque(false);           
        }
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
    private java.awt.Button btnFind;
    private javax.swing.JLabel btn_exit;
    private java.awt.Button button2;
    private javax.swing.JComboBox<String> chbFrom;
    private javax.swing.JComboBox<String> chbTo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlbFrom;
    private javax.swing.JLabel jlbFrom1;
    private javax.swing.JLabel jlbTo;
    // End of variables declaration//GEN-END:variables
}
