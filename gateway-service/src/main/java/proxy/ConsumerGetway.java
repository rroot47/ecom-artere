package proxy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerGetway {

    @KafkaListener(topics = "R1", groupId = "r1-2")
    public void onMessage(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        System.out.println("***************************");
        ResponseDTO cart = bookParse(consumerRecord.value());
        System.out.println(" => " + cart.getId() + "\n"  +cart.getProductItem() );
        System.out.println("***************************");
    }
    //Git Hooks
    private ResponseDTO bookParse(String book) throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();
        return jsonMapper.readValue(book, ResponseDTO.class);
    }
}
