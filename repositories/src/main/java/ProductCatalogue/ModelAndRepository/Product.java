package ProductCatalogue.ModelAndRepository;

import ProductCatalogue.ModelAndRepository.Manufacturer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Table(name = "Batches")
@JsonPropertyOrder({"batch_id", "name", "batch", "price", "quantity"})
@Entity
@ApiModel(description="Details about the batches")
public @Data class Product implements Serializable {

    @JsonProperty("batch_id")
    @ApiModelProperty(notes="The unique ID by which we identify the Batch")
    private @Id int batchid;

    @ApiModelProperty(notes= "Name of Batch")
    private  String name;

    @ApiModelProperty(notes = "Code of Batch")
    private  String batch;

    @ApiModelProperty(notes = "Price of Batch")
    private  double price;

    @ApiModelProperty(notes = "Quantity available of a Batch")
    private  int quantity;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "List of Products in a Batch")
    private List<Manufacturer> products=new ArrayList<Manufacturer>();
    public Product(){}

    public Product(int batchid, String name, String batch, double price, int quantity){
        super();
        this.batchid=batchid;
        this.name=name;
        this.batch=batch;
        this.price=price;
        this.quantity=quantity;

    }
}