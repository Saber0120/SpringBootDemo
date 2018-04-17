package com.saber;

import com.saber.config.Info;
import com.saber.config.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Chapter212Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Chapter212Application.class, args);
        Binder binder = Binder.get(context.getEnvironment());

        //绑定简单配置（基本配置）
//		UserConfig config = binder.bind("com.saber", 	Bindable.of(UserConfig.class)).get();
//		System.out.println(config.getUsername());
        //绑定List
//        List<String> list = binder.bind("com.saber.url", Bindable.listOf(String.class)).get();
//        System.out.println(list.size());
        //绑定Map
        List<Info> infoList = binder.bind("com.saber.urls", Bindable.listOf(Info.class)).get();
        System.out.println(infoList.size());
    }
}
