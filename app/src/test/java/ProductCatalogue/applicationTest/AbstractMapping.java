package ProductCatalogue.applicationTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AbstractMapping {
    //protected MockMvc mvc;
    //@Autowired
    //WebApplicationContext wcontext;

    //protected void setUp(){
        //mvc= MockMvcBuilders.webAppContextSetup(wcontext).build();
   // }
    protected String mapToJson(Object obj) throws JsonProcessingException{
        ObjectMapper objMap=new ObjectMapper();
        return objMap.writeValueAsString(obj);
    }
    protected <T> T mapFromJson(String json, Class<T> c) throws JsonParseException, IOException, JsonMappingException{
        ObjectMapper objMap=new ObjectMapper();
        return objMap.readValue(json, c);
    }
}
