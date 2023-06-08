package cart.services;

import cart.dto.ResponseCartDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class Consumer {
    @KafkaListener(topics = "R1", groupId = "r1-1")
    public void onMessage(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        System.out.println("***************************");
        ResponseCartDTO book = bookParse(consumerRecord.value());
        System.out.println(" => " + book.getId() + " ,"  + book.getProductItem());
        System.out.println("***************************");
    }
    //Git Hooks

    private ResponseCartDTO bookParse(String book) throws JsonProcessingException {
        JsonMapper jsonMapper = new JsonMapper();
        return jsonMapper.readValue(book, ResponseCartDTO.class);
    }

}
