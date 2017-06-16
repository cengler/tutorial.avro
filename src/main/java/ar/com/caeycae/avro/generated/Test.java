package ar.com.caeycae.avro.generated;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by christianengler on 16/06/17.
 */
public class Test {

    public static void main(String[] args) throws Exception
    {
        List<Empleado> empleados = new ArrayList<>();

        Empleado e1=new Empleado();
        e1.setName("Juan");
        e1.setAge(21);
        e1.setSalary(30000);
        e1.setAddress("Buenos Aires");
        e1.setId(001);
        empleados.add(e1);

        Empleado e2=new Empleado();
        e2.setName("Domingo");
        e2.setAge(30);
        e2.setSalary(40000);
        e2.setAddress("Cordoba");
        e2.setId(002);
        empleados.add(e2);

        Empleado e3=new Empleado();
        e3.setName("Esteban");
        e3.setAge(25);
        e3.setSalary(35000);
        e3.setAddress("Santa Fe");
        e3.setId(003);
        empleados.add(e3);

        SerializeEmpleado.serialize(empleados, "empleados.avro");
        List<Empleado> des = DeserializeEmpleado.deserialize("empleados.avro");
        for (Empleado e : des)
            System.out.println(e);
        new File("empleados.avro").delete();
    }
}
