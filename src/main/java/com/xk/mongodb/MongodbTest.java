package com.xk.mongodb;

import com.xk.mongodb.bean.Book;
import com.xk.mongodb.utils.MongodbUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbTest {

    @Autowired
    MongodbUtils mongodbUtils;

    @Test
    public void testSave1() {
        Book model = new Book("1",24.0f,"三体1","中国科幻第一巨著·刘慈欣著","中信出版社");
        mongodbUtils.save(model);
    }

    @Test
    public void testSave2() {
        Book model = new Book("4",24.0f,"三体2","中国科幻第一巨著·刘慈欣著","中信出版社");
        mongodbUtils.save(model, "book");

    }

    @Test
    public void testRemove1() {

        Book obj = new Book();
        String[] findKeys = { "name" };
        String[] findValues = { "三体1" };
        Book result = (Book)mongodbUtils.findOne(obj, findKeys, findValues);
        System.out.println(result);
        mongodbUtils.remove(result);
    }

    @Test
    public void testRemove2() {
        Book obj = new Book();
        String[] findKeys = { "name" };
        String[] findValues = { "三体1" };
        Book result = (Book)mongodbUtils.findOne(obj, findKeys, findValues);
        System.out.println("testRemove2:    "+result);
        mongodbUtils.remove(result,"book");

    }

    @Test
    public void testRemove3() {
        mongodbUtils.removeById("_id", "123", "mongodbTestModel");
    }

    @Test
    public void testUpdate1() {
        String accordingKey = "_id";
        String accordingValue = "e933f48a-cc68-4993-9069-820ff3adab34";
        String[] updateKeys = { "name", "age" };
        Object[] updateValues = { "tat", "22222" };
        String collectionName = "test23";
        mongodbUtils.updateFirst(accordingKey, accordingValue, updateKeys, updateValues, collectionName);
    }

    @Test
    public void testUpdate2() {
        String accordingKey = "name";
        String accordingValue = "tat";
        String[] updateKeys = { "age" };
        Object[] updateValues = { "000000" };
        String collectionName = "test23";
        mongodbUtils.updateMulti(accordingKey, accordingValue, updateKeys, updateValues, collectionName);
    }

    @Test
    public void testFind1() {
        Book obj = new Book();
        String[] findKeys = { "info", "publish" };
        String[] findValues = { "中国科幻第一巨著·刘慈欣著", "中信出版社" };
        List<? extends Object> find = mongodbUtils.find(obj, findKeys, findValues);
        System.out.println(find);
    }

    @Test
    public void testFind2() {
        Book model = new Book("1",24.0f,"三体1","中国科幻第一巨著·刘慈欣著","中信出版社");
        mongodbUtils.save(model);

        Book obj = new Book();
        String[] findKeys = { "name" };
        String[] findValues = { "三体1" };
        String collectionName = "book";
        List<? extends Object> find = mongodbUtils.find(obj, findKeys, findValues, collectionName);
        System.out.println(find);
    }

    @Test
    public void testFind3() {

        Book model = new Book("5",24.0f,"三体1","中国科幻第一巨著·刘慈欣著","中信出版社");
        mongodbUtils.save(model);

        Book obj = new Book();
        String[] findKeys = { "name" };
        String[] findValues = { "三体1" };
        String collectionName = "book";
        Object findOne = mongodbUtils.findOne(obj, findKeys, findValues, collectionName);
        System.out.println(findOne);
    }

    @Test
    public void testFind4() {
        List<Book> findAll = (List<Book>)mongodbUtils.findAll(new Book());
        System.out.println(findAll);
    }

    @Test
    public void testFind5() {
        List<? extends Object> findAll = mongodbUtils.findAll(new Book(),"book");
        System.out.println(findAll);
    }


}
