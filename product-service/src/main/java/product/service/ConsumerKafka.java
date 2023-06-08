package product.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import product.dto.CartDTO;

@Service
public class ConsumerKafka {

    @KafkaListener(topics = "R1", groupId = "r1-1")
    public void onMessage(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        System.out.println("***************************");
        CartDTO cart = bookParse(consumerRecord.value());
        System.out.println(" => " + cart.getId() + " , "  +cart.getProductItem() );
        System.out.println("***************************");
    }
    //Git Hooks

    private CartDTO bookParse(String book) throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();
        return jsonMapper.readValue(book, CartDTO.class);
    }
}
