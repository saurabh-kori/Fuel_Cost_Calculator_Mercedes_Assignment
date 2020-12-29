package com.assignment.FuelCostCalculator.publisher;

import java.util.Random;

import com.assignment.FuelCostCalculator.config.MessagingConfig;
import com.assignment.FuelCostCalculator.dataClass.LocationAndEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locEvent")
public class LocationEventPublisher {
    
    @Autowired
    private RabbitTemplate template;

    private String allIndiaLocation[] = new String[]{"CHIKMAGALUR","TUMKUR","BANGALORE","DHARWAD","BANGALORE+RURAL","DAKSHIN+KANNAD","MYSORE","UTTAR+KANNAD","RAICHUR","UDUPI","CHITRADURGA","HASSAN","SHIMOGA","GULBARGA","DAVANGERE","BELLARY","BIDAR","KOPPAL","BIJAPUR","CHIKKABALLAPURA","BAGALKOT","YADGIR","CHAMRAJNAGAR","RAMANAGARA","HAVERI","GADAG","BELGAUM","MANDYA","KOLAR","KODAGU"};
    private boolean event[] = new boolean[]{true,false};
    
    @Scheduled(initialDelay = 1000L,fixedDelayString = "PT2M")
    @PostMapping("/loc")
    public String getLocationEvent(){

        int randomLocation = new Random().nextInt(allIndiaLocation.length);
        int randomEvent = new Random().nextInt(event.length);

        // loc1.setLocation(allIndiaLocation[randomLocation]);
        // loc1.setEvent(event[randomEvent]);
        LocationAndEvent loc1 = new LocationAndEvent(allIndiaLocation[randomLocation],event[randomEvent]);
        

        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, loc1);

        return "Location and event value sent successfully";
    }

}
