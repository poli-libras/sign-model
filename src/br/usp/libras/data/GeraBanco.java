package br.usp.libras.data;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Gera o banco de dados com base nas anotações JPA e no hibernate.cfg.xml
 * 
 * ATENÇÃO: se o banco já existir, 
 * esse script causará a perda de todos os dados! =0
 *
 */
public class GeraBanco {

    public static void main(String[] args) {
        Configuration conf = new AnnotationConfiguration();
        conf.configure();
        SchemaExport se = new SchemaExport(conf);
        se.create(true, true);
    }
}