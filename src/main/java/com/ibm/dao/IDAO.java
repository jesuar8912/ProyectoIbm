/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.dao;

import java.util.List;

/**
 *
 * @author JesusArmando
 * @param <T>
 */
public interface IDAO<T> {

    public T agregar(T t);

    public T buscar(int i);
    
    public List<T> buscarTodos();

    public T eliminar(int i);

    public T actualizar(T t);
}
