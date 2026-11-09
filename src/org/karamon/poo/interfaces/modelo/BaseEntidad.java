package org.karamon.poo.interfaces.modelo;

import java.util.Objects;

public class BaseEntidad {
    private static int ultimoId;
    private Integer id;

    public BaseEntidad() {
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntidad baseEntidad = (BaseEntidad) o;
        return Objects.equals(id, baseEntidad.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
