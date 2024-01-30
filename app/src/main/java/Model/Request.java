package Model;

import java.util.List;

public class Request {
    private String TableNo;
    private  String name;
    private String phone_number;
    private String total;
    private String status;
    private String comment;
    // list of food orders
    private List<Order> foods;

    public Request() {
    }


    public Request(String tableNo, String name, String phone_number, String total, String status, String comment, List<Order> foods) {
        TableNo = tableNo;
        this.name = name;
        this.phone_number = phone_number;
        this.total = total;
        this.status = status;
        this.comment = comment;
        this.foods = foods;
    }

    public String getTableNo() {
        return TableNo;
    }

    public void setTableNo(String tableNo) {
        TableNo = tableNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}
