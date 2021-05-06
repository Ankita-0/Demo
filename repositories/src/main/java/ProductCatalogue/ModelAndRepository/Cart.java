package ProductCatalogue.ModelAndRepository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name= "CartItems")
@Entity
@ApiModel(description="Details about the products present in cart")
public @Data class Cart {

    @ApiModelProperty(notes = "The unique ID by which we identify Batch")
    private @Column int batchid;

    @ApiModelProperty(notes = "The unique ID by which we identify Product")
    @Column
    private @Id int id;

    @ApiModelProperty(notes = "Name of the Product")
    private @Column String name;

    @ApiModelProperty(notes = "Quantity of Product in the Cart")
    private @Column int quantity;

    public Cart(){}

    public Cart(int batchid, int id, String name, int quantity){
        this.batchid=batchid;
        this.id=id;
        this.name=name;
        this.quantity=quantity;
    }
}
