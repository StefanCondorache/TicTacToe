import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeCondorache {

    public static void main(String[] args) {
        JFrame frame = new JFrame("TicTacToeCondorache");
        frame.setContentPane(new TicTacToeCondorache().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private JPanel Panel4;
    private JPanel Panel5;
    private JPanel Panel6;
    private JPanel Panel7;
    private JPanel Panel8;
    private JPanel Panel9;
    private JPanel Panel10;
    private JPanel Panel11;
    private JPanel Panel12;
    private JPanel Panel13;
    private JPanel Panel14;
    private JPanel Panel15;
    private JTextField textFieldX;
    private JTextField textField0;
    private JButton RESETButton;
    private JButton EXITButton;
    private JLabel labelX;
    private JLabel label0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    JButton[] array = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};
    private final ArrayList<JButton> arrayButtons = new ArrayList<>(List.of(array));

    private int xCount = 0, oCount = 0;
    private String startGame = "X";
    private int[] astahuitelna = new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    int moves = 0;

    public TicTacToeCondorache() {
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame dialog = new JFrame();
                if( JOptionPane.showConfirmDialog( dialog, "Wanna quit?", "EXIT Program", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_NO_OPTION ) {
                    System.exit(0);
                }
            }
        });
        RESETButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for( JButton button : arrayButtons ) { button.setText(null); }

                astahuitelna = new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2 };

                for( JButton button : arrayButtons ) { button.setEnabled(true); }

                moves = 0;

                for( JButton button : arrayButtons ) { button.setBackground(new Color(128, 255, 128)); }
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                source.setText(startGame);
                if( startGame.equalsIgnoreCase("X") ) {
                    source.setForeground(Color.BLUE);
                    astahuitelna[arrayButtons.indexOf((source))] = 1;
                    moves++;
                    source.setUI(new MetalButtonUI(){
                        protected Color getDisabledTextColor() {
                            return Color.BLUE;
                        }
                    });
                    source.setEnabled(false);
                }
                else{
                    source.setForeground(Color.RED);
                    astahuitelna[arrayButtons.indexOf((source))] = 0;
                    moves++;
                    source.setUI(new MetalButtonUI(){
                       protected Color getDisabledTextColor() {
                           return Color.RED;
                       }
                    });
                    source.setEnabled(false);
                }
                changePLayer();
                winner();
            }
        };

        for( JButton button : arrayButtons ) { button.addActionListener(listener); }

    }

    private void changePLayer(){ startGame = (startGame.equalsIgnoreCase("X"))? "O" : "X"; }

    private final String[] winCase = new String[]{"012", "345", "678", "036", "147", "258", "048", "246"};

    private void winner(){
        for( String oneCase : winCase ){
            int index1 = oneCase.charAt(0) - '0';
            int index2 = oneCase.charAt(1) - '0';
            int index3 = oneCase.charAt(2) - '0';

            if( astahuitelna[index1] == 1 && astahuitelna[index2] == 1 && astahuitelna[index3] == 1 ){
                xCount++;
                textFieldX.setText(String.valueOf(xCount));
                arrayButtons.get(index1).setBackground(Color.YELLOW);
                arrayButtons.get(index2).setBackground(Color.YELLOW);
                arrayButtons.get(index3).setBackground(Color.YELLOW);
                JFrame announceWinner = new JFrame();
                JOptionPane.showMessageDialog(announceWinner, "X WINS!!!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                for( JButton button : arrayButtons ) { button.setEnabled(false); }
                break;
            }
            else if(astahuitelna[index1] == 0 && astahuitelna[index2] == 0 && astahuitelna[index3] == 0){
                oCount++;
                textField0.setText(String.valueOf(oCount));
                arrayButtons.get(index1).setBackground(Color.YELLOW);
                arrayButtons.get(index2).setBackground(Color.YELLOW);
                arrayButtons.get(index3).setBackground(Color.YELLOW);
                JFrame announceWinner = new JFrame();
                JOptionPane.showMessageDialog(announceWinner, "O WINS!!!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                for( JButton button : arrayButtons ) { button.setEnabled(false); }
                break;
            }
            else if( moves == 9){
                JFrame announceWinner = new JFrame();
                JOptionPane.showMessageDialog(announceWinner, "No one wins", "Winner", JOptionPane.INFORMATION_MESSAGE);
                for( JButton button : arrayButtons ) { button.setEnabled(false); }
                break;
            }
        }



    }

}
