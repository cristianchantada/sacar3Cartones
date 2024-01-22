
import java.awt.*;
import javax.swing.*;

public class Aplicacion {

    public static final String PATH = "C:\\Users\\Usuario\\Desktop\\sacar3Cartones\\src\\";
    static JFrame frame;
    static JPanel panel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Scroll Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        frame.setSize(800, 700);
        frame.setLocationRelativeTo(null);

        int numCartones = 0;
        String numCartonesStr = JOptionPane.showInputDialog("Ingrese el número de cartones que desea");

        try {
            numCartones = Integer.parseInt(numCartonesStr);
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Ingresa un número, melón");
            main(null);
        }




        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(0, 900 + (275 * numCartones)));
        scrollPane.setViewportView(panel);
        frame.getContentPane().add(scrollPane);

        // Colocar logo IES VDA e imagen representa cart´´on bolas rojas
        ImageIcon miimagen1 = new ImageIcon(PATH + "imgBingo\\bingoIESVDA.png");
        JLabel label1 = new JLabel(miimagen1);
        label1.setBounds(49, 8, 300, 249);
        panel.add(label1);
        panel.setComponentZOrder(label1, 0);

        ImageIcon miimagen2 = new ImageIcon(PATH + "imgBingo\\tableroNumeros.png");
        JLabel label2 = new JLabel(miimagen2);
        label2.setBounds(477, 7, 300, 249);
        panel.add(label2);
        panel.setComponentZOrder(label2, 0);

        // Colocar cartón vacío
        for(int i = 0; i < numCartones; i++) {
            int movimientoVerticalPanel = 275 * i;
            ImageIcon miimagen3 = new ImageIcon(PATH + "imgBingo\\CartonBingoEnBlanco.png");
            JLabel label3 = new JLabel(miimagen3);
            label3.setBounds(113, 260+movimientoVerticalPanel, 600, 297);
            panel.add(label3);
            panel.setComponentZOrder(label3, 0);
        }

        // Colocamos bolas
        for(int i = 0; i < numCartones; i++){
            CartonVDA carton = new CartonVDA(i);
            carton.mostrarBolasCartonVDA(panel);
        }

        frame.setVisible(true);

    }
}
