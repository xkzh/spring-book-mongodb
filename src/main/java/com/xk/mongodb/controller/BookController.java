package com.xk.mongodb.controller;

import com.xk.mongodb.bean.Book;
import com.xk.mongodb.response.BaseResult;
import com.xk.mongodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService mongoDbService;

    @PostMapping("/save")
    @ResponseBody
    public BaseResult saveObj(@RequestBody Book book) {
        return BaseResult.success(mongoDbService.saveObj(book));
    }

    @GetMapping("/findAll")
    @ResponseBody
    public BaseResult findAll() {
        return BaseResult.success(mongoDbService.findAll());
    }

    @GetMapping("/findOne")
    @ResponseBody
    public BaseResult findOne(@RequestParam String id) {
        return BaseResult.success(mongoDbService.getBookById(id));
    }

    @GetMapping("/findOneByName")
    @ResponseBody
    public BaseResult findOneByName(@RequestParam String name) {
        return BaseResult.success(mongoDbService.getBookByName(name));
    }

    @PostMapping("/update")
    @ResponseBody
    public BaseResult update(@RequestBody Book book) {
        return BaseResult.success(mongoDbService.updateBook(book));
    }

    @PostMapping("/delOne")
    @ResponseBody
    public BaseResult delOne(@RequestBody Book book) {
        return BaseResult.success(mongoDbService.deleteBook(book));
    }

    @GetMapping("/delById")
    @ResponseBody
    public BaseResult delById(@RequestParam String id) {
        return BaseResult.success(mongoDbService.deleteBookById(id));
    }

    @GetMapping("/find-likes")
    @ResponseBody
    public BaseResult findByLikes(@RequestParam String search) {
        return BaseResult.success(mongoDbService.findByLikes(search));
    }


}
