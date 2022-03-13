package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

public class Productor {

    public static void main(String[] args) {
        //System.out.println("Hello Kafka");

        // Crear objeto de propiedades para Productor
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //bootstrap.servers
        //key.serializer
        //value.serializer

        // Crear el Productor
        final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

        // Crear el registro de productor
        ProducerRecord<String,String> mensaje1=new ProducerRecord<String ,String> ("demo","key1","Mi mensaje 1");
        ProducerRecord<String,String> mensaje2=new ProducerRecord<String ,String> ("demo","key1","Mi mensaje 2");

        // Enviar datos - Asíncrono
        producer.send(mensaje1);
        producer.send(mensaje2);

        // vaciar y cerrar el productor
        producer.flush();
        producer.close();
    }

}
