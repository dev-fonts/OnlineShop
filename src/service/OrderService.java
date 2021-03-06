package service;

import entity.Customer;
import entity.Item;
import entity.Order;
import repository.OrderRepository;
import repository.OrderedItemsRepository;
import utils.Constant;
import utils.DateParser;
import utils.FileReader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    CustomerService customerService = new CustomerService();
    OrderRepository orderRepository = new OrderRepository();
    OrderedItemsRepository orderedItemsRepository = new OrderedItemsRepository();
    ItemService itemService = new ItemService();

    public List<Order> parse() {
        String customersFilePath = Constant.CUSTOMERS_FILE_PATH;
        List<String> orderDataList = FileReader.read(customersFilePath);
        List<Order> ordersList = new ArrayList<>();
        for (String str : orderDataList) {
            String[] tempArray = str.split(";");
            Customer customer = customerService.getByName(tempArray[0]);
            LocalDate orderPlacementDate = DateParser.parse(tempArray[6], Constant.ORDER_PLACEMENT_DATE_PATTERN);
            Order order = new Order(customer, orderPlacementDate);

            List<Item> items = getPurchasedItems(tempArray[5]);
            order.setOrderedItems(items);

            ordersList.add(order);
        }
        return ordersList;
    }

    public List<Integer> getItemCodes(String str) {
        List<Integer> listOfProductCodes = new ArrayList<>();
        String strWithoutQuotes = str.substring(1, str.length() - 1);
        if (strWithoutQuotes.length() > 2) {
            String[] tempArray = strWithoutQuotes.split(" ");
            for (String s : tempArray) {
                int code = 0;
                code = Integer.valueOf(s);
                listOfProductCodes.add(code);
            }
        } else {
            listOfProductCodes.add(Integer.valueOf(strWithoutQuotes));
        }
        return listOfProductCodes;
    }

    public List<Item> parseItems(List<Integer> itemCodes) {
        List<Item> items = new ArrayList<>();
        for (Integer i : itemCodes) {
            Item item = itemService.getById(i);
            items.add(item);
        }
        return items;
    }

    public List<Item> getPurchasedItems(String str) {
        return parseItems(getItemCodes(str));
    }

    public boolean save(Order o) {
        orderRepository.save(o);
        return true;
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public List<Item> getAllOrderedItems() {
        return orderedItemsRepository.getAll();
    }
}