package pdm.carlos.android.javalanches.classes;

import java.io.Serializable;

public class Mesa implements Serializable {
    private int codigo;
    private boolean ocupado;

    public Mesa() {
    }

    public Mesa(int codigo) {
        super();
        this.codigo = codigo;
        this.ocupado = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}