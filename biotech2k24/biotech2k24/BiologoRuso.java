package biotech2k24;

public class BiologoRuso {
    private String apellido;
    private String cedula;
    private String genero;

    public BiologoRuso(String apellido, String cedula, String genero) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.genero = genero;
    }

    public String getApellido() {
        return apellido;
    }

    public int getUltimoDigitoCedula() {
        return Integer.parseInt(cedula.substring(cedula.length() - 1));
    }

    public String getGenero() {
        return genero;
    }
}
