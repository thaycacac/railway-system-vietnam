
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

    /**
     * Creates new form Main
     */
    int V,INF;
	ArrayList<Pair> vertexMapping;
	ArrayList<ArrayList<Pair> > adjList;
	ArrayList<Pair> l;
    public Main() {
        initComponents();
        V = 0;
        INF = 9999999;
	vertexMapping = new  ArrayList<Pair>();
	adjList = new ArrayList<ArrayList<Pair> >();
	l = new ArrayList<Pair>();
    }
    
    public void shortestPath(int src,int sink){
		Graphics g= getGraphics();
		int width = 50,height=50;
		int i=0;
		while(i<adjList.size()){
			Iterator itr = adjList.get(i).iterator();
			Pair pcor = vertexMapping.get(i);
			int x = pcor.getx();
			int y = pcor.gety();
			while(itr.hasNext()){
				Pair p = (Pair)itr.next();
				Pair pcor1 = vertexMapping.get(p.getx());
				int x1 = pcor1.getx();
				int y1 = pcor1.gety();
				g.drawLine(x,y,x1,y1);
			}
			i++;
		}
		for(i=0;i<vertexMapping.size();i++){
			Pair p = vertexMapping.get(i);
			int x = p.getx();
			int y = p.gety();
			g.setColor(new Color(190,255,190));
			g.fillOval(x-width/2,y-height/2,width,height);
			g.setColor(Color.BLACK);
			g.drawOval(x-width/2,y-height/2,width,height);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.drawString((new Integer(i)).toString(),x-5,y+5);
		}
		int[] dist = new int[V];
		int[] parent = new int[V];
		boolean[] doneWith = new boolean[V];
		for(i=0;i<V;i++){
			dist[i] = INF;
			doneWith[i] = false;
			parent[i]=-1;
		}
		dist[src]=0;
		Comparator<Pair> comparator = new MyComparator();
		PriorityQueue <Pair>  q = new PriorityQueue <Pair> (comparator); 
		q.add(new Pair(0,src));
		while(q.size()!=0){
			Pair p = q.poll();
			int u = p.gety();
			if(doneWith[u])
				continue;
			doneWith[u] = true;
			Iterator itr = adjList.get(u).iterator();
			while(itr.hasNext()){
				Pair pr = (Pair)itr.next();
				int v = pr.getx();
				int weight = pr.gety();
				if(!doneWith[v] && dist[v]>dist[u]+weight){
					dist[v] = dist[u]+weight;
					parent[v]=u;
					q.add(new Pair(dist[v],v));
				}
			}
		}
		printParentEdges(sink,parent);
		printParent(sink,parent);
	}
    public void invertNode(int vertex){
		Pair p = vertexMapping.get(vertex);
		int x = p.getx();
		int y = p.gety();	
		int width =50,height=50;
		Graphics g= getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval(x-width/2,y-height/2,width,height);
		g.setColor(Color.RED);
		g.drawOval(x-width/2,y-height/2,width,height);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString((new Integer(vertex)).toString(),x-5,y+5);		
	}
	public void invertEdge(int vertex,int par){
		Graphics g= getGraphics();
		Pair p = vertexMapping.get(vertex);
		int x = p.getx();
		int y = p.gety();
		g.setColor(Color.RED);
		Pair p1 = vertexMapping.get(par);
		int x1 = p1.getx();
		int y1 = p1.gety();
		g.drawLine(x,y,x1,y1);
	}
	public void printParentEdges(int vertex,int[] parent){
		if(parent[vertex]==-1){
			return;
		}
		printParentEdges(parent[vertex],parent);
		invertEdge(vertex,parent[vertex]);		
	}
	public void printParent(int vertex,int[] parent){
		if(parent[vertex]==-1){
			invertNode(vertex);
			return;
		}
		printParent(parent[vertex],parent);
		invertNode(vertex);		
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

        jlbWeight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbWeight.setText("Weight");

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
                            .addComponent(btnFind, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addContainerGap(332, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

		adjList.add(new ArrayList<Pair>());
		Integer i = new Integer(V);
		int x = evt.getX();
		int y = evt.getY();
		vertexMapping.add(new Pair(x,y));
		int width =50,height=50;
		String text = i.toString();
		Graphics g= getGraphics();
		g.setColor(new Color(190,255,190));
		g.fillOval(x-width/2,y-height/2,width,height);
		g.setColor(Color.BLACK);
		g.drawOval(x-width/2,y-height/2,width,height);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString(text,x-5,y+5);
		V++;
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
                        int from = Integer.valueOf(tfFrom.getText());
			int to = Integer.valueOf(tfTo.getText());
			int weight = Integer.valueOf(tfWeight.getText());
			if(weight<0 || to>vertexMapping.size() || from>vertexMapping.size() || to<0 || from<0){
				tfFrom.setText("INVALID");
				tfTo.setText("INVALID");
				tfWeight.setText("INVALID");
				return;
			}
			tfFrom.setText("");
			tfTo.setText("");
			tfWeight.setText("");
			int x1 = vertexMapping.get(from).getx();
			int y1 = vertexMapping.get(from).gety();
			int x2 = vertexMapping.get(to).getx();
			int y2 = vertexMapping.get(to).gety();
			Graphics g= getGraphics();	
			int midx = (x1+x2)/2;
			int midy = (y1+y2)/2;
			g.drawLine(x1,y1,x2,y2);
			g.setColor(new Color(190,255,190));
			g.fillOval(x1-50/2,y1-50/2,50,50);
			g.setColor(Color.BLACK);
			g.drawOval(x1-50/2,y1-50/2,50,50);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.drawString(new Integer(from).toString(),x1-5,y1+5);
			g.setColor(new Color(190,255,190));
			g.fillOval(x2-50/2,y2-50/2,50,50);
			g.setColor(Color.BLACK);
			g.drawOval(x2-50/2,y2-50/2,50,50);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.drawString(new Integer(to).toString(),x2-5,y2+5);	
			g.drawString(new Integer(weight).toString(),midx-5,midy+5);
			adjList.get(from).add(new Pair(to,weight));
			adjList.get(to).add(new Pair(from,weight));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
                        int fromFind = Integer.valueOf(tfFromFind.getText());
			int toFind = Integer.valueOf(tfToFind.getText());
                        //check input find valid or not
			if(fromFind<0 || fromFind>V || toFind<0 || toFind>V){
				tfFromFind.setText("INVALID");
				tfToFind.setText("INVALID");
			}
			shortestPath(fromFind,toFind);
    }//GEN-LAST:event_btnFindActionPerformed

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
    
    class Pair{
	int x,y;
	public Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
	public int getx(){
		return x;
	}
	public int gety(){
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
    private javax.swing.JButton btnFind;
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
