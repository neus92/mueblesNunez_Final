package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Materiales {
    private int id;
    private String[] material = {"Americano", "Vintage", "Clasico","Moderno","Rustico"};
    private int [] precios = {500000,700000,650000,800000,900000};

    public Materiales()
    {}

    public Materiales(int id, String[] material, int[] precios) {
        this.id = id;
        this.material = material;
        this.precios = precios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getMaterial() {
        return material;
    }

    public void setMaterial(String[] material) {
        this.material = material;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materiales that = (Materiales) o;
        return id == that.id && Arrays.equals(material, that.material) && Arrays.equals(precios, that.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(material);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    //Metodo para añadir valor adicional al precio

    public int anadirAdicional (int valor, int adicional)
    {
        return valor + adicional;
    }

}


