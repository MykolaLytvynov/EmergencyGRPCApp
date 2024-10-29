package ua.mykola.emergencygrpcapp.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(String notification) {
        System.out.println(notification);
    }
}
