package org.karamon.poo.interfaces.repositorio;

public interface CompletoRepositorio<T> extends OrdenableRepositorio<T>, PaginableRepositorio<T>, CrudRepositorio<T>, ContableRepositorio {
}
