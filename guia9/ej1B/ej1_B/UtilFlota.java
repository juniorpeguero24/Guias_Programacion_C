package ej1_B;

import java.util.ArrayList;

// Conversion entre el modelo y los DTO, en los dos sentidos.
// Modelo -> DTO: getters del modelo + setters del DTO.
// DTO -> Modelo: getters del DTO + el unico constructor de cada clase del modelo.
public class UtilFlota {

    // ===================== MODELO -> DTO =====================

    public static MotorDTO motorToDTO(Motor motor) {
        MotorDTO dto = new MotorDTO();
        dto.setN_serie(motor.getN_serie());
        dto.setCombustible(motor.getCombustible());
        return dto;
    }

    public static AutomovilDTO automovilToDTO(Automovil auto) {
        AutomovilDTO dto = new AutomovilDTO();
        dto.setN_Chasis(auto.getN_Chasis());                 // datos de Vehiculo
        dto.setAnio_fabricacion(auto.getAnio_fabricacion());
        dto.setMarca(auto.getMarca());                       // datos de Automovil
        dto.setModelo(auto.getModelo());
        dto.setPatente(auto.getPatente());
        dto.setMotor(motorToDTO(auto.getMotor()));
        return dto;
    }

    public static FlotaDTO flotaToDTO(Flota flota) {
        FlotaDTO dto = new FlotaDTO();
        dto.setNombre(flota.getNombre());
        ArrayList<AutomovilDTO> autos = new ArrayList<>();
        for (Automovil a : flota.getAutomoviles()) {
            autos.add(automovilToDTO(a));
        }
        dto.setAutomoviles(autos);
        return dto;
    }

    // ===================== DTO -> MODELO =====================
    // Se arma de adentro hacia afuera: primero el motor, despues el auto, al final la flota.

    public static Motor dtoToMotor(MotorDTO dto) {
        return new Motor(dto.getN_serie(), dto.getCombustible());
    }

    public static Automovil dtoToAutomovil(AutomovilDTO dto) {
        return new Automovil(dto.getN_Chasis(), dto.getAnio_fabricacion(),
                dtoToMotor(dto.getMotor()), dto.getMarca(), dto.getModelo(), dto.getPatente());
    }

    public static Flota dtoToFlota(FlotaDTO dto) {
        ArrayList<Automovil> autos = new ArrayList<>();
        for (AutomovilDTO a : dto.getAutomoviles()) {
            autos.add(dtoToAutomovil(a));
        }
        return new Flota(dto.getNombre(), autos);
    }
}
