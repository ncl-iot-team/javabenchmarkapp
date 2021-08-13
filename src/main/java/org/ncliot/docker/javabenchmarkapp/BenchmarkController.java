package org.ncliot.docker.javabenchmarkapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BenchmarkController {

    Logger logger = LoggerFactory.getLogger(BenchmarkController.class);


    @RequestMapping("/primecheck/{num}")
    public String checkPrime(@PathVariable long num) {
        boolean flag = false;
        List<String> dummyList= new ArrayList<String>();
        long startTime = System.nanoTime()/1000000;
        for(long i = 2; i <= num/2; ++i)
        {
            // condition for nonprime number
           // logger.info("Check:"+num%i);
            dummyList.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis convallis nisi sagittis null");
            if(num % i == 0)
            {
                flag = true;
                break;
            }
        }

        long elapsedTime = (System.nanoTime()/1000000)-startTime;

        if (!flag) {
            logger.info(num + " is a prime number.\n Time taken: " + elapsedTime);
            return num + " is a prime number.\n Time taken: " + elapsedTime;
        }
        else
        {
            logger.info(num + " is not a prime number. Time taken:" + elapsedTime);
            return num + " is not a prime number. Time taken:" + elapsedTime;
        }
    }

    @RequestMapping("/primecheck")
    public String checkPrime() {
        long num=86028121;
        return checkPrime(num);
    }


}
