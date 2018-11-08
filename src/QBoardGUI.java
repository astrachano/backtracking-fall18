
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
public class QBoardGUI extends JFrame implements IQueenState{
    
    private QBoard myBoard;
    private JButton[][] myButtons;
    private int myDelay;
    private static Font ourFont = new Font("Monospaced", Font.BOLD,24);

    private ImageIcon myCrown,myQuestion;
    private static int BSIZE = 60;
    
    public QBoardGUI(int n){
        myDelay = 500;
        myButtons = new JButton[n][n];
        myBoard = new QBoard(n);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(n,n,0,0));
        initialize(panel);
        JPanel mainPanel = (JPanel) getContentPane();
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.add(getSlider(), BorderLayout.SOUTH);
        pack();
        myCrown = new ImageIcon("crown2.png");
        Image img = myCrown.getImage().getScaledInstance(BSIZE, BSIZE, java.awt.Image.SCALE_SMOOTH);
        myCrown = new ImageIcon(img);
        myQuestion = new ImageIcon("qmark.png");
        Image img2 = myQuestion.getImage().getScaledInstance(BSIZE, BSIZE, java.awt.Image.SCALE_SMOOTH);
        myQuestion = new ImageIcon(img2);
        setVisible(true);
        
        if (myQuestion == null) {
        	System.out.println("oops ? null");
        }
        else {
        	System.out.printf("width = %d\n", myQuestion.getImage().getWidth(null));
        }
    }
    
    public JPanel getSlider(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        JSlider slider = new JSlider(0,1000);
        slider.addChangeListener(new ChangeListener(){

            public void stateChanged(ChangeEvent e) {
                myDelay = ((JSlider) e.getSource()).getValue();
            }
            
        }); 
        panel.add(Box.createRigidArea(new Dimension(50,0)));
        panel.add(new JLabel("fast"));
        panel.add(slider);
        panel.add(new JLabel("slow"));
        panel.add(Box.createRigidArea(new Dimension(50,0)));
        return panel;
    }
    
    private void initialize(JPanel panel){
        for(int k=0; k < myButtons.length; k++){
            for(int j=0; j < myButtons.length; j++){
                myButtons[k][j] = new JButton(myCrown);
                myButtons[k][j].setFont(ourFont);
                myButtons[k][j].setPreferredSize(new Dimension(BSIZE,BSIZE));
                myButtons[k][j].setIcon(null);
                panel.add(myButtons[k][j]);
            }
        }
    }
    
    public boolean isOn(JButton button){
    	return button.getIcon() != null;
    }
    
    public boolean reset(int row, int col, boolean value){
        pause();
        myButtons[row][col].setIcon(null);
        return value;
    }
    
    public boolean safeToPlace(int row, int col){
        myButtons[row][col].setIcon(myQuestion);
        if (myBoard.safeToPlace(row,col)){
            return reset(row,col,true);
        }
        else {
            return reset(row,col,false);
        }
    }
    
    public void setQueen(int row, int col, boolean value){
            myBoard.setQueen(row,col,value);
            myButtons[row][col].setIcon(value? myCrown : null);
       
    }
    
    public void print(){
       myBoard.print();
    }
    
    public void pause(){
        try {
            Thread.sleep(myDelay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
