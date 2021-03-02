package com.timur.databasebiblioteca.gui;

/**
 * @author Timur
 */
public interface FormIntF<T> {
    T readForm();

    void clearForm();

    void fillForm(T t);
}
