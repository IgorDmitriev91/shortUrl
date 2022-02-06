package com.example.demo.controller;

import com.example.demo.entity.CreateShortUrl;
import com.example.demo.entity.UpgreatUrl;
import com.example.demo.entity.Url;
import com.example.demo.exception_handling.NoSuchUrlException;
import com.example.demo.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;


@RestController
@RequestMapping("/shortUrl")
public class MyRESTController {
    @Autowired
   private UrlService service;


    @GetMapping("/urls")
    public List<Url> showAllURLs(){
       return service.getAllURL();
    }

    @GetMapping("/urls/{id}")
    public Url showURL(@PathVariable int id){
        Url url = service.getUrl(id);
        if(url == null){
            throw new NoSuchUrlException("There is no url with ID = " + id + " in Database");
        }
        return url;
    }

    @PostMapping("/urls")
    public Url addNewUrl(@RequestBody Url url){

        UpgreatUrl upgreatUrl = new UpgreatUrl();
        CreateShortUrl createShortUrl = new CreateShortUrl();
        String name = url.getNameURl();

            if(upgreatUrl.startURL(name) && upgreatUrl.finishURL(name)){
                    url.setNameURl("https://"+name);
                }
                else{
                throw new NoSuchUrlException("The url must start www. and end .com/ru/org");
                }
        url.setShortURL(createShortUrl.shortURL());
        String shortUrl = url.getShortURL();

        service.saveUrl(url);

        return url;
    }

    @DeleteMapping("/urls/{id}")
    public String deleteUrl(@PathVariable  int id){
        service.deleteUrl(id);
        return "Url with id= " + id + " was deleted";

    }
    @RequestMapping("/{shortUrl}")
    public RedirectView redirectUrl(@PathVariable String shortUrl){
        String nameShortUrl ="";
        String nameUrl = "";
        List<Url> list = service.getAllURL();
        for (int i = 0; i < list.size(); i++) {
            nameShortUrl = list.get(i).getShortURL();
            if (shortUrl.equals(nameShortUrl)) {
                Url url = list.get(i);
                int count = url.getCount();
                count++;
                url.setCount(count);
                service.saveUrl(url);

                nameUrl = url.getNameURl();
                return new RedirectView(nameUrl);
            }
        }

        return new RedirectView(nameUrl);
    }
}
