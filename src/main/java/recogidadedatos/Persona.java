package recogidadedatos;


import com.google.gson.annotations.SerializedName;

public class Persona {
    //Serializar el nombre permite ponerle el nombre que muestra
    @SerializedName("name")
    private String nombre;
    @SerializedName("surname")
    private String apellidos;
    private Integer edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

}
