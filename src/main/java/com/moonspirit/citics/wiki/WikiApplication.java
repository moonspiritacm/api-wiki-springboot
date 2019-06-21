package com.moonspirit.citics.wiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName      WikiApplication
 * @Description    应用启动类
 * @author         moonspirit
 * @date           2019年6月17日 下午11:49:42
 * @version        1.0.0
 */
@SpringBootApplication
@EnableTransactionManagement
public class WikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikiApplication.class, args);
	}

}
