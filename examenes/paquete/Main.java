package paquete;

import java.util.ArrayList;

public class Main implements Cloneable{
    private ArrayList<Paciente> pacientes;

    public Main() {
        this.pacientes = new ArrayList<>();
    }


    @Override
    public Object clone() throws CloneNotSupportedException{
        try {
            ArrayList<Paciente> ps = (ArrayList<Paciente>) super.clone();
            if (!this.pacientes.isEmpty()){
                for (Paciente p : this.pacientes) {
                    ps.add((Paciente) p.clone());
                }
            }
            return ps;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.getMessage());
        }
    }
}
