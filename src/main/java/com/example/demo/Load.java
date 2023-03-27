package com.example.demo;


import jakarta.persistence.*;

//«машина»: ID, Вид техники (например, мультиварка), Группа техники (например, бытовые
//приборы), Дата ввоза на склад, Дата вывоза со склада, ФИО водителя, увозящего технику со склада.
//CREATE TABLE load (
//   ID int (15) NOT NULL AUTO_INCREMENT,
//   name_load varchar (255) NOT NULL,
//   content varchar (255) NOT NULL,
//   city_from varchar (255) NOT NULL,
//   city_to varchar (255) NOT NULL,
//   data_input datetime NOT NULL,
//   data_output datetime NOT NULL,
//   PRIMARY KEY (ID)
//                    ) ENGINE=InnODB DEFAULT CHARSET=UTF8
// сущность которую нужно сохранять в базе данных

//Параметры объекта «сеанс»: ID, Название фильма, Киностудия, Дата и время сеанса, Количество билетов на сеанс.
@Entity
@Table(name="Load", schema="WAREHOUSE")
public class Load {

    @Column(name = "ID")
    private Long ID;

    @Column(name = "name_load")
    private String name_load;

    @Column(name = "content")
    private String content;

    @Column(name = "city_from")
    private String city_from;

    @Column(name = "city_to")
    private String city_to;

    @Column(name = "data_output")
    private String data_output;

    @Column(name = "data_input")
    private String data_input;

    protected Load(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name_load;
    }

    public void setName(String name) {
        this.name_load = name_load;
    }

    public String content() {
        return content;
    }

    public void content(String content) {
        this.content = content;
    }

    public String getCity_from() {
        return city_from;
    }

    public void setCity_from(String city_from) {
        this.city_from = city_from;
    }

    public String getCity_to() {
        return city_to;
    }

    public void setCity_to(String city_to) {
        this.city_to = city_to;
    }

    public String getData_output() {
        return data_output;
    }

    public void setData_output(String data_output) {
        this.data_output = data_output;
    }
    public String getData_input() {
        return data_input;
    }

    public void setData_input(String data_input) {
        this.data_input = data_input;
    }
}