package ar.com.caeycae.avro.parser;

import ar.com.caeycae.avro.generated.DeserializeEmpleado;
import ar.com.caeycae.avro.generated.Empleado;
import ar.com.caeycae.avro.generated.SerializeEmpleado;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by christianengler on 16/06/17.
 */
public class TestParser {

    public static void main(String[] args) throws Exception
    {
        DatumWriter<GenericRecord> datumWriter;
        DatumReader<GenericRecord> datumReader;
        DataFileWriter<GenericRecord> dataFileWriter = null;
        DataFileReader<GenericRecord> dataFileReader = null;

        Schema schema = new Schema.Parser().parse(new File("Empleado.avsc"));

        GenericRecord e1 = new GenericData.Record(schema);
        e1.put("name", "Juan");
        e1.put("age", 21);
        e1.put("salary", 30000);
        e1.put("address", "Buenos Aires");
        e1.put("id", 1);

        datumWriter = new GenericDatumWriter<>(schema);

        dataFileWriter = new DataFileWriter<>(datumWriter);
        dataFileWriter.create(schema, new File("empleados2.avro"));

        dataFileWriter.append(e1);
        dataFileWriter.close();

        datumReader = new GenericDatumReader<>(schema);
        dataFileReader = new DataFileReader<>(
                new File("empleados2.avro"), datumReader);
        GenericRecord emp = null;

        while (dataFileReader.hasNext()) {
            emp = dataFileReader.next(emp);
            System.out.println(emp);
        }

        dataFileReader.close();

    }
}
