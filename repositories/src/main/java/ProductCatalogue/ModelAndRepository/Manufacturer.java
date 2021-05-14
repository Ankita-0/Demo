package ProductCatalogue.ModelAndRepository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;


@Table(name = "Products")
@Entity
@ApiModel(description="Details about the products present in Batches")
public @Data class Manufacturer {

    @ManyToOne(targetEntity = Product.class, optional = false)
    @JoinColumn(name = "batchid", insertable = false, updatable = false)
    @JsonIgnore
    private Product product;

    @JsonIgnore
    private int batchid;

    @ApiModelProperty(notes = "The unique ID by which we identify the Product")
    private @Id int id;

    @ApiModelProperty(notes = "Name of the Product")
    private String name;

    @ApiModelProperty(notes = "Price of the Product")
    private double price;

    public Manufacturer() {
    }

    public Manufacturer(int batchid, int id, String name, double price) {
        this.batchid = batchid;
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
