package br.com.dbccompany.vemser.avaliaser.util;

import br.com.dbccompany.vemser.avaliaser.dto.CargoDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulation {

    private Manipulation() {}

    public static Properties getProp(CargoDTO cargo) {

        Properties props = new Properties();

        try {
            if (cargo.equals(CargoDTO.ADMIN)) {
                FileInputStream file = new FileInputStream("src/properties/dados-admin.properties");
                props.load(file);
            } else if (cargo.equals(CargoDTO.GESTOR)) {
                FileInputStream file = new FileInputStream("src/properties/dados-gestor.properties");
                props.load(file);
            } else if (cargo.equals(CargoDTO.INSTRUTOR)) {
                FileInputStream file = new FileInputStream("src/properties/dados-instrutor.properties");
                props.load(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }
}