package com.xk.mongodb;



import com.xk.mongodb.bean.Book;
import com.xk.mongodb.service.BookService;
import com.xk.mongodb.service.BookServiceImpl;
import com.xk.mongodb.utils.MongodbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/***
 *  初始化系统数据
 *
 */
@Component
public class InitConfig {


    private static final Logger log = LoggerFactory.getLogger(InitConfig.class);
    @Resource
    private BookService bookService;

    @Autowired
    MongodbUtils mongodbUtils;

    @PostConstruct
    public void init(){
        Long count = bookService.countAll();
        log.error("countAll count:   "+count);
        if(count == 0){
            List<Book> list = getData();
            for(Book book : list){
                bookService.saveObj(book);
            }
        }
    }

//    public Book(String id, Integer price, String name, String info, String publish)

    public List<Book> getData(){
        List<Book> list = new ArrayList<>();
        list.add(new Book("1",24.0f,"白鹿原","陈忠实茅盾文学奖获奖作品","中信出版社"));
        list.add(new Book("2",38.8f,"乔布斯传","沃尔特·艾萨克森对乔布斯的传记","中信出版社"));
        list.add(new Book("3",46.0f,"Java Head First","Java编程入门书籍","中信出版社"));
        return  list;
    }

}
