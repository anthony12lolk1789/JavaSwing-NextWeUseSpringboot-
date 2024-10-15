package Controlador;
import Vista.FrInventarios_Vista;
import Vista.Inventario_Vista;
import Vista.Menu_Principal_Vista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmInventarios_Controlador  {
    private FrInventarios_Vista vistainventario;
    public FrmInventarios_Controlador(FrInventarios_Vista vistainventario){
        this.vistainventario = vistainventario;
        //Agregando listeners a los botones para que funcionen
        //Volver
        vistainventario.getBtnVolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Inventario_Vista MpVista = new Inventario_Vista();
                Inventario_Controlador  cont = new Inventario_Controlador(MpVista);
                MpVista.setVisible(true);
                vistainventario.dispose();

            };

        });
    }

}
