package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Category;
import java.util.List;
/**
 * Created by 梦 on 2017/3/15.
 */
public interface CategoryDAO {

    List<Category> getCategoryList();

    Category getCategory(String categoryID);
}
