import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ventanaprim  extends JFrame implements MouseListener {
        JLabel etiqueta;
        JButton boton;
        JPanel panel;
        JTextField miTexto;

        public Ventanaprim(){

            initComponent();

        }

        private void initComponent() {
            //caracteristicas de ventana
            setSize(300,200);
            this.setTitle("prueba de ventana");
            this.setResizable(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            //componentes de la ventana
           JPanel panel=new JPanel();
            boton=new JButton("prueba");
            etiqueta=new JLabel("etiqueta");
            miTexto=new JTextField("0",20);
            boton.addMouseListener(this);

            panel.add(boton);
            panel.add(etiqueta);
            panel.add(miTexto);

            //panel.setLayout(flow);

            FlowLayout miFlow= new FlowLayout(FlowLayout.CENTER,3,3 );
            setLayout(miFlow);
            add(etiqueta);
            add(miTexto);
            add(boton);

            this.setContentPane(panel);

            this.setVisible(true);
        }

    @Override
    public void mouseClicked(MouseEvent e) {
        String val=miTexto.getText();
        int iVal=Integer.parseInt(val);
        iVal++;
        miTexto.setText(Integer.toString(iVal));
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

