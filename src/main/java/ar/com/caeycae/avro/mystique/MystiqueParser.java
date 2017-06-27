package ar.com.caeycae.avro.mystique;

import com.despegar.sem.connect.mystique.Relationships;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by christianengler on 27/06/17.
 */
public class MystiqueParser {

    public static void main(String[] args) {

        DataFileReader<GenericRecord> dataFileReader = null;
        try {
            Schema schema = new Schema.Parser().parse(new File("relationships.avsc"));

            DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema);
            BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(new FileInputStream("test4.avro"), null);
            GenericRecord result = reader.read(null, decoder);
            System.out.printf(result.toString());


          /*  DatumReader<Relationships> readerR = new GenericDatumReader<>(schema);
            BinaryDecoder decoderR = DecoderFactory.get().binaryDecoder(new FileInputStream("test4.avro"), null);
            Relationships resultR = readerR.read(null, decoderR);
            System.out.printf(resultR.toString());
*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dataFileReader != null)
                try {
                    dataFileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

}
