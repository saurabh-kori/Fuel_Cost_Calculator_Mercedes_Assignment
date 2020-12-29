package com.assignment.FuelCostCalculator.consumer;

import com.assignment.FuelCostCalculator.config.MessagingConfig;
import com.assignment.FuelCostCalculator.dataClass.LocationAndEvent;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Component
public class FetchingFuelPrice {
    
    static StringBuffer data;
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeFromQueue(LocationAndEvent loc1) throws Exception{
        if(loc1.isEvent()){
            Gson gson=new Gson();
            data=new StringBuffer("");
            URL url=new URL("https://fuelprice-api-india.herokuapp.com/price/Karnataka/"+loc1.getLocation());
            HttpURLConnection conn=(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // System.out.println(conn.getResponseCode());
            Scanner sc=new Scanner(url.openStream());
            while(sc.hasNext()){
            data.append(sc.nextLine());
            }
            data.deleteCharAt(data.length()-1);
            data.deleteCharAt(0);
         
            DataModel model=gson.fromJson(String.valueOf(data), DataModel.class);
            List<Product> fetched_products=model.getProducts();
            String sPrice = fetched_products.get(0).getProductPrice();
            Float price = Float.valueOf(sPrice).floatValue();

            //Here we are taking fuel lid is open for 2 min 
            int fuelLidOpenTime = 2 ; //2min
            //amount of fuel per min is 2 litre
            int fuelAmount = 2; //2 litre of fuel per min
            //Calculating total price
            float totalPrice = price*fuelAmount*fuelLidOpenTime;
            System.out.println("Total price of fuel in 2 min for location "+loc1.getLocation()+":"+totalPrice);
           
        }else{
            System.out.println("Fuel lid is closed we can't calculate the fuel price for location "+loc1.getLocation());
        }
        
    }
}
