import model.dao.CommonQuery;
import model.dao.PersonsDao;
import model.dao.ProductDao;
import model.dao.UserDao;

public class Main {
    private  final  static  String GET_ALL="SELECT * FROM persons";
    private  final  static  String GET_ONLY_ADULTS="SELECT * FROM persons WHERE age>17";
    private  final  static  String GET_ALL_BY_ORDER="SELECT * FROM products1 ORDER BY price";
    private  final  static  String GET_ALL_WHERE_PRICE_MORE_THEN="SELECT * FROM products1 WHERE price>25 ";
    private  final  static  String GET_USER_PERSONAL_DATA="SELECT * FROM usertest WHERE user_login LIKE  'm%' OR 'p%' ";


    public static void main(String[] args) {
        System.out.println(new PersonsDao().getAll(GET_ALL));
        System.out.println(new PersonsDao().getAll(GET_ONLY_ADULTS));
        System.out.println(new ProductDao().getAll(GET_ALL_BY_ORDER));
        System.out.println(new ProductDao().getAll(GET_ALL_WHERE_PRICE_MORE_THEN));
        System.out.println(new UserDao().getAll(GET_USER_PERSONAL_DATA));
    }
}
