package it22049.stores;

import it22049.models.Customer;
import it22049.models.DeliveryPlace;
import it22049.models.Driver;
import it22049.models.Order;
import it22049.models.OrderRating;
import it22049.models.Product;
import it22049.models.ProductCategory;
import it22049.models.ProductInOrder;
import java.util.ArrayList;
import java.util.List;

public class InitializeData {
    
    public static void init(){
        DriverStore.drivers.add(new Driver("Ioannis", "Papaioannou","Kallithea El. Venizelou 76", "io.papaioannou@gmail.com","12345679","MYB-975",false));
        DriverStore.drivers.add(new Driver("Konstantinos", "Papaspuroy","Moschato tsaldari 66", "ko.papaspuroy@gmail.com","432684630","MIZ-654",true));
        DriverStore.drivers.add(new Driver("Ilias", "Papatheodorou","Kifisia Irakleous 43", "ilias.papatheodorou@gmail.com","324761039","MEH-845",true));
        DriverStore.drivers.add(new Driver("Dimitrios", "Papachristou","Kallithea Menelaou 73", "jim.papachristou@gmail.com","473674764","NYX-836",true));

        ProductStore.products.add(new Product("Απορυπαντικό πιάτων",ProductCategory.DETERGENT,"Fairy"));
        ProductStore.products.add(new Product("Κόκα κόλα",ProductCategory.BEVERAGE,"Pepsi"));
        ProductStore.products.add(new Product("Χλωρίνη",ProductCategory.HYGIENE_PRODUCT,"Klinex"));
        ProductStore.products.add(new Product("Πατατάκια",ProductCategory.FOOD,"Lays"));
        
        DeliveryPlace deliveryPlace1 = new DeliveryPlace("Monastiraki ermou 29");
        deliveryPlace1.addEmptyLockers(5);
        DeliveryPlace deliveryPlace2 = new DeliveryPlace("Syntagma plakas 34");
        deliveryPlace2.addEmptyLockers(4);
        DeliveryPlace deliveryPlace3 = new DeliveryPlace("Dafni kaleou 94");
        deliveryPlace3.addEmptyLockers(3);
        DeliveryPlace deliveryPlace4 = new DeliveryPlace("Argiroupoli stenou 94");
        deliveryPlace4.addEmptyLockers(6);
        DeliveryPlaceStore.delivryPlaces.add(deliveryPlace1);
        DeliveryPlaceStore.delivryPlaces.add(deliveryPlace2);
        DeliveryPlaceStore.delivryPlaces.add(deliveryPlace3);
        DeliveryPlaceStore.delivryPlaces.add(deliveryPlace4);
        
        
        CustomerStore.customers.add(new Customer("Theodoros", "Karagiannis","Kallithea Ifigenias 76", "th.karagiannis@gmail.com"));
        CustomerStore.customers.add(new Customer("Theofanis", "Karachristou","Kallithea Mantzagriotaki 66", "th.karachristou@gmail.com"));
        CustomerStore.customers.add(new Customer("Theocharis", "Karageorgiou","Kallithea Irakleous 23", "th.karageorgiou@gmail.com"));
        CustomerStore.customers.add(new Customer("Christodoulos", "Karagiannidis","Kallithea Ag.Panton 73", "th.karagiannidis@gmail.com"));

        List<ProductInOrder> products1 = new ArrayList<>();
        products1.add(new ProductInOrder(ProductStore.products.get(0),2));
        products1.add(new ProductInOrder(ProductStore.products.get(3),2));
        
        OrderStore.orders.add(new Order(1,CustomerStore.customers.get(0),DriverStore.drivers.get(0),products1,"Kallithea Ifigenias 76",null,null));
        
        List<ProductInOrder> products2 = new ArrayList<>();
        products2.add(new ProductInOrder(ProductStore.products.get(2),5));
        products2.add(new ProductInOrder(ProductStore.products.get(1),1));
        
        OrderStore.orders.add(new Order(2,CustomerStore.customers.get(1),DriverStore.drivers.get(1),products2,null,DeliveryPlaceStore.delivryPlaces.get(0),DeliveryPlaceStore.delivryPlaces.get(0).getEmptyLocker()));
        
        List<ProductInOrder> products3 = new ArrayList<>();
        products3.add(new ProductInOrder(ProductStore.products.get(0),2));
        products3.add(new ProductInOrder(ProductStore.products.get(2),1));
        
        OrderStore.orders.add(new Order(3,CustomerStore.customers.get(2),DriverStore.drivers.get(2),products3,null,DeliveryPlaceStore.delivryPlaces.get(1),DeliveryPlaceStore.delivryPlaces.get(1).getEmptyLocker()));
        
        List<ProductInOrder> products4 = new ArrayList<>();
        products4.add(new ProductInOrder(ProductStore.products.get(0),2));
        products4.add(new ProductInOrder(ProductStore.products.get(1),3));
        
        OrderStore.orders.add(new Order(4,CustomerStore.customers.get(3),DriverStore.drivers.get(3),products4,null,DeliveryPlaceStore.delivryPlaces.get(2),DeliveryPlaceStore.delivryPlaces.get(2).getEmptyLocker()));
         
        
        OrderRatingStore.ratings.add(new OrderRating(OrderStore.orders.get(0),8));
        OrderRatingStore.ratings.add(new OrderRating(OrderStore.orders.get(1),6));
        OrderRatingStore.ratings.add(new OrderRating(OrderStore.orders.get(2),10));
        OrderRatingStore.ratings.add(new OrderRating(OrderStore.orders.get(3),3));

    }
    
    
}
