package ar.com.caeycae.avro.generated;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by christianengler on 16/06/17.
 */
public class DeserializeEmpleado {

    public static List<Empleado> deserialize(String path) throws IOException
    {
        DatumReader<Empleado> empDatumReader = new SpecificDatumReader<>(Empleado.class);
        DataFileReader<Empleado> dataFileReader = new DataFileReader<>(new File(path), empDatumReader);

        Empleado em=null;
        List<Empleado> list = new ArrayList<>();

        while(dataFileReader.hasNext()){
            em=dataFileReader.next();
            list.add(em);
        }

        return list;
    }

}
