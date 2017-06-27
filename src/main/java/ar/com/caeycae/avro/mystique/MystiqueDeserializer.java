package ar.com.caeycae.avro.mystique;

import ar.com.caeycae.avro.generated.Empleado;
import com.despegar.sem.connect.mystique.Relationships;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by christianengler on 27/06/17.
 */
public class MystiqueDeserializer {

    public static void main(String[] args) throws IOException {
        DatumReader<Relationships> empDatumReader = new SpecificDatumReader<>(Relationships.class);

        BinaryDecoder decoderR = DecoderFactory.get().binaryDecoder(
                new FileInputStream("test4.avro"), null);

        Relationships s = empDatumReader.read(null, decoderR);
        System.out.println(s);
    }
}
