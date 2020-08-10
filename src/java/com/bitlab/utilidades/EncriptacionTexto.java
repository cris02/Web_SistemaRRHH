/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import java.util.logging.Logger;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Aguilar
 */
public class EncriptacionTexto {

    private static Logger log = Logger.getLogger(EncriptacionTexto.class.getName());
    private static final String LLAVE_VAL = "Cris09Ag$05."; //mi llave de encriptacion
    BasicTextEncryptor encryptor;

    //constructor para asignar una nueva llave
    public EncriptacionTexto(String valor) {
        encryptor = new BasicTextEncryptor();
        if (valor == null || valor.length() == 0) {
            valor = LLAVE_VAL;
        }

        encryptor.setPassword(valor);
    }

    //constructor para asignar mi llave por defecto
    public EncriptacionTexto() {
        log.info("Iniciando el encriptador de texto");
        encryptor = new BasicTextEncryptor();
        encryptor.setPassword(LLAVE_VAL);
    }

    //metodo para encriptar textos
    public String getTextoEncriptado(String texto) {
        log.info("Texto Encriptado");
        return encryptor.encrypt(texto);
    }

    //metodo para desencriptar textos
    public String getTextoDesencriptado(String texto) {
        log.info("Texto Desencriptado");
        return encryptor.decrypt(texto);
    }
}
