package org.karamon.poo.interfaces.repositorio;

import org.karamon.poo.interfaces.modelo.BaseEntidad;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntidad> implements CompletoRepositorio<T> {

    private final List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    public List<T> getDataSource() {
        return dataSource;
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) {
        T tBuscar = null;
        for (T t : dataSource) {
            if (t.getId() != null && t.getId().equals(id)) {
                tBuscar = t;
                break;
            }
        }
        return tBuscar;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);

    }

    @Override
    public void eliminar(Integer id) {

        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {

        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}

