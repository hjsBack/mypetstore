package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Product;
import java.util.List;
/**
 * Created by 梦 on 2017/3/15.
 */
public interface ProductDAO {

    List<Product> getProductListByCategory(String categoryID);

    Product getProduct(String productID);

    List<Product> searchProductList(String keywords);

    List<String> getAllProductName();

}
