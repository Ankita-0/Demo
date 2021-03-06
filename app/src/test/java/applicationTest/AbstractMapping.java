package applicationTest;

import ProductCatalogue.ProductApplication;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

public class AbstractMapping {

    protected String mapToJson(Object obj) throws JsonProcessingException{
        ObjectMapper objMap=new ObjectMapper();
        return objMap.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> c) throws JsonParseException, IOException, JsonMappingException{
        ObjectMapper objMap=new ObjectMapper();
        return objMap.readValue(json, c);
    }
}
