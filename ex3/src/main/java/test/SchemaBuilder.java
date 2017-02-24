package test;

import javax.persistence.Persistence;

/**
 *
 * @author Peter
 */
public class SchemaBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
    }
    
}
