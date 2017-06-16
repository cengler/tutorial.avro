package ar.com.caeycae.avro.generated;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by christianengler on 16/06/17.
 */
public class SerializeEmpleado {

    public static void serialize(List<Empleado> empleados, String filePath) throws IOException
    {
        DatumWriter<Empleado> empDatumWriter = new SpecificDatumWriter<>(Empleado.class);
        DataFileWriter<Empleado> empFileWriter = new DataFileWriter<>(empDatumWriter);

        empFileWriter.create(Empleado.getClassSchema(), new File(filePath));

        for (Empleado e : empleados) {
            empFileWriter.append(e);
        }

        empFileWriter.close();

        System.out.println("Exito rotundo");
    }
}
